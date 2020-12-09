package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.OrdenDeTrabajo;
import com.cenfotec.examen.entities.Producto;
import com.cenfotec.examen.repositories.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenDeTrabajoRepository repository;

    public List<OrdenDeTrabajo> getAllOrdenes() {
        return repository.findAll();
    }

    public List<OrdenDeTrabajo> getAllOrdenesXTipoProducto(int tipoProductoId) {
        Producto producto = new Producto();
        producto.setId(tipoProductoId);
        return repository.findByTipoProducto(producto);
    }

    public OrdenDeTrabajo createOrden(OrdenDeTrabajo ordenDeTrabajo) {
        return repository.save(ordenDeTrabajo);
    }

    public OrdenDeTrabajo updateOrden(int id, OrdenDeTrabajo ordenDeTrabajo) {
        return repository.findById(id)
                .map(record -> {
                    record.getTipoProducto().setTipoProducto(ordenDeTrabajo.getTipoProducto().getTipoProducto());
                    record.setCantidad(ordenDeTrabajo.getCantidad());
                    return repository.save(record);
                }).orElse(null);
    }

    public boolean deleteOrden(int id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(null);
    }

}
