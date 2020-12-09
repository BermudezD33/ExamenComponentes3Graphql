package com.cenfotec.examen.repositories;

import com.cenfotec.examen.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
