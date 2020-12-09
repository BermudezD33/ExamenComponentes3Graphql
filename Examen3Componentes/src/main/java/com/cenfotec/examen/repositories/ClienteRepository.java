package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    List<Cliente> findByApellidoClienteLike(String apellido);
    List<Cliente> findByDireccionCobroLike(String direccionCobro);

}
