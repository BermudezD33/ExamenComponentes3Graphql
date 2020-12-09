package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.repositories.ClienteRepository;
import com.cenfotec.examen.repositories.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private OrdenDeTrabajoRepository ordenRepository;


    public List<Cliente>    getAllClientes(String apellidoCliente, String direccionCobro) {

        if (apellidoCliente != null && !apellidoCliente.trim().equals("")) {
            return repository.findByApellidoClienteLike("%" + apellidoCliente + "%");
        } else if (direccionCobro != null && !direccionCobro.trim().equals("")) {
            return repository.findByDireccionCobroLike("%" + direccionCobro + "%");
        } else {
            return repository.findAll();
        }
    }

    public Cliente findById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Cliente createCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente updateCliente(int id, Cliente cliente) {
        return repository.findById(id)
                .map(record -> {
                    record.setNombreCliente(cliente.getNombreCliente());
                    record.setApellidoCliente(cliente.getApellidoCliente());
                    record.setDireccionCliente(cliente.getDireccionCliente());
                    record.setDireccionCobro(cliente.getDireccionCobro());
                    record.setNumeroTarjeta(cliente.getNumeroTarjeta());
                    record.setMesVencimiento(cliente.getMesVencimiento());
                    record.setAnioVencimiento(cliente.getAnioVencimiento());
                    return repository.save(record);
                }).orElse(null);
    }


    public int deleteCliente(int id) {
        return repository.findById(id)
                .map(cliente -> {
                    if (ordenRepository.findByClienteAsociado(cliente).isEmpty()) {
                        repository.deleteById(id);
                        return 1;
                    } else {
                        return 2;
                    }
                }).orElse(-1);
    }

}
