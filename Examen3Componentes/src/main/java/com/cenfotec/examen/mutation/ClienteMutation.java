package com.cenfotec.examen.mutation;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.services.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMutation implements GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente createCliente(String nombreCliente, String apellidoCliente, String direccionCliente,
                                 String direccionCobro, String numeroTarjeta, int anioVencimiento,
                                 int mesVencimiento) {
        Cliente cliente = new Cliente();
        cliente.setNombreCliente(nombreCliente);
        cliente.setApellidoCliente(apellidoCliente);
        cliente.setDireccionCliente(direccionCliente);
        cliente.setDireccionCobro(direccionCobro);
        cliente.setNumeroTarjeta(numeroTarjeta);
        cliente.setAnioVencimiento(anioVencimiento);
        cliente.setMesVencimiento(mesVencimiento);
        return this.service.createCliente(cliente);
    }

    public Cliente updateCliente(String nombreCliente, String apellidoCliente, String direccionCliente,
                                 String direccionCobro, String numeroTarjeta, int anioVencimiento,
                                 int mesVencimiento, int id) {

        Cliente clienteModificado = new Cliente();
        clienteModificado.setNombreCliente(nombreCliente);
        clienteModificado.setApellidoCliente(apellidoCliente);
        clienteModificado.setDireccionCliente(direccionCliente);
        clienteModificado.setDireccionCobro(direccionCobro);
        clienteModificado.setNumeroTarjeta(numeroTarjeta);
        clienteModificado.setAnioVencimiento(anioVencimiento);
        clienteModificado.setMesVencimiento(mesVencimiento);
        return this.service.updateCliente(id, clienteModificado);

    }

    public String deleteCliente(int id) {
        if (this.service.deleteCliente(id) == 1) {
            return "Cliente eliminado!";
        } else if (this.service.deleteCliente(id) == 2) {
            return "El cliente no puede ser eliminado!";
        } else {
            return "El id es incorrecto";
        }
    }

}
