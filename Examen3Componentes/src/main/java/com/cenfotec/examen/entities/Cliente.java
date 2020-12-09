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
public class Cliente implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;
    @Column(name = "apellido_cliente", nullable = false)
    private String apellidoCliente;
    @Column(name = "direccion_cliente")
    private String direccionCliente;
    @Column(name = "direccion_cobro")
    private String direccionCobro;
    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;
    @Column(name = "mes_vencimiento")
    private int mesVencimiento;
    @Column(name = "anio_vencimiento")
    private int anioVencimiento;

}
