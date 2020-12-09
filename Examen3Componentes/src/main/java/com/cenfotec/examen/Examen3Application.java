package com.cenfotec.examen;

import com.cenfotec.examen.entities.Producto;
import com.cenfotec.examen.services.ProductoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Examen3Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Examen3Application.class, args);
        ProductoService productoService = context.getBean(ProductoService.class);
        Producto productoTasa = new Producto();
        Producto productoCamiseta = new Producto();
        Producto productoAlmohadon = new Producto();
        Producto productoVaso = new Producto();
       
        productoTasa.setTipoProducto("tasa");
        productoCamiseta.setTipoProducto("camiseta");
        productoAlmohadon.setTipoProducto("almohadon");
        productoVaso.setTipoProducto("vaso");

        productoTasa.setCosto(15);
        productoCamiseta.setCosto(9);
        productoAlmohadon.setCosto(8);
        productoVaso.setCosto(13);

        productoService.createProducto(productoTasa);
        productoService.createProducto(productoCamiseta);
        productoService.createProducto(productoAlmohadon);
        productoService.createProducto(productoVaso);
    }

}
