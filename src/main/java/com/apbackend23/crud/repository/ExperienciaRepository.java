package com.apbackend23.crud.repository;

import com.apbackend23.crud.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HCanestraro
 */

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long> {


}
