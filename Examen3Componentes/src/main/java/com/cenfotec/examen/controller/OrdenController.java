package com.cenfotec.examen.controller;

import com.cenfotec.examen.entities.OrdenDeTrabajo;
import com.cenfotec.examen.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/ordenes"})
public class OrdenController {

    @Autowired
    private OrdenService service;

    @GetMapping()
    public ResponseEntity<?> findOrdenes(
            @RequestParam(name = "tipo_producto_id", required = false) String tipoProducto) {
        try {
            if (tipoProducto != null) {
                Integer tipoProductoId = Integer.parseInt(tipoProducto);
                return ResponseEntity.ok(service.getAllOrdenesXTipoProducto(tipoProductoId));
            } else {
                return ResponseEntity.ok(service.getAllOrdenes());
            }
        } catch (NumberFormatException nfe) {
            return ResponseEntity.badRequest().body("El parametro de tipo_producto_id es invalido");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }

    @PostMapping
    public ResponseEntity<?> createOrden(@RequestBody OrdenDeTrabajo ordenDeTrabajo) {
        try {
            return ResponseEntity.ok(service.createOrden(ordenDeTrabajo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody OrdenDeTrabajo ordenDeTrabajo) {
        try {
            OrdenDeTrabajo ordenModificado = service.updateOrden(id, ordenDeTrabajo);
            if (ordenDeTrabajo != null) {
                return ResponseEntity.ok().body(ordenModificado);
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
        try {
            boolean borrado = service.deleteOrden(id);
            if (borrado) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo interno del servidor");
        }
    }
}
