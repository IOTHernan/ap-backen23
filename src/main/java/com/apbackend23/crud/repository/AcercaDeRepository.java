package com.apbackend23.crud.repository;


import com.apbackend23.crud.entity.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HCanestraro
 */

@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Long> {


}
