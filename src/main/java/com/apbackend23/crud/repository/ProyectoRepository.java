package com.apbackend23.crud.repository;

import com.apbackend23.crud.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HCanestraro
 */

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {


}
