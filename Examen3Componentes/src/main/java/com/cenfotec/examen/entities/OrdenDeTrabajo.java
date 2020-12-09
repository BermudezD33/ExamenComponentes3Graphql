package com.cenfotec.examen.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode
@Entity
public class OrdenDeTrabajo implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "tipo_producto")
    private Producto tipoProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "path_imagen")
    private String pathImagen;

    @OneToOne
    @JoinColumn(name = "cliente_asociado")
    private Cliente clienteAsociado;


}
