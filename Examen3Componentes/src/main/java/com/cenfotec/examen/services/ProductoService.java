package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Producto;
import com.cenfotec.examen.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> getAllProductos() {
        return repository.findAll();
    }


    public Producto findById(int id) {
        return repository.findById(id)
                .orElse(null);

    }

    public Producto createProducto(Producto producto) {
        return repository.save(producto);
    }

    public Producto updateProducto(int id, Producto producto) {
        return repository.findById(id)
                .map(record -> {
                    record.setCosto(producto.getCosto());
                    record.setTipoProducto(producto.getTipoProducto());
                    return repository.save(record);
                }).orElse(null);
    }

    public boolean deleteProducto(int id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(null);
    }

}
