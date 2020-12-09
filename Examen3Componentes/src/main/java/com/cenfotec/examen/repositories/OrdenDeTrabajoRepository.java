package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Cliente;
import com.cenfotec.examen.entities.OrdenDeTrabajo;
import com.cenfotec.examen.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajo,Integer> {
    List<OrdenDeTrabajo> findByTipoProducto(Producto producto);
    List<OrdenDeTrabajo> findByClienteAsociado(Cliente cliente);

}
