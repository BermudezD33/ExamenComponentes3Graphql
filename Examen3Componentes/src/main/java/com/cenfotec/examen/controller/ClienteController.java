package com.cenfotec.examen.controller;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Cliente cliente = service.findById(id);
            if (cliente != null) {
                return ResponseEntity.ok().body(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }

    @GetMapping()
    public ResponseEntity<?> findAll(
            @RequestParam(name = "apellido_cliente", required = false) String apellidoCliente,
            @RequestParam(name = "direccion_cobro", required = false) String direccionCobro) {
        try {
            return ResponseEntity.ok(service.getAllClientes(apellidoCliente, direccionCobro));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(service.createCliente(cliente));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteModificado = service.updateCliente(id, cliente);
            if (clienteModificado != null) {
                return ResponseEntity.ok().body(clienteModificado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }


    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        int borrado = service.deleteCliente(id);
        if (borrado == 1) {
            return ResponseEntity.ok().build();
        } else if (borrado == 2) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario tiene ordenes asociadas!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
