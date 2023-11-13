package com.apbackend23.crud.service;

import com.apbackend23.crud.entity.Experiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apbackend23.crud.repository.ExperienciaRepository;

/**
 *
 * @author HCanestraro
 */

@Service
public class ExperienciaService  {

    @Autowired
    public ExperienciaRepository experienciaRepo;


    public List<Experiencia> verExperiencias(){
        return experienciaRepo.findAll();
    }


    public void crearExperiencia(Experiencia expe){
        experienciaRepo.save(expe);
    }


    public void borrarExperiencia (Long id){
        experienciaRepo.deleteById(id);
    }


    public Experiencia buscarExperiencia(Long id){
        return experienciaRepo.findById(id).orElse(null);
    }


    public void editarExperiencia (Long id, Experiencia expe){
        experienciaRepo.findById(id).map( editExpe -> {
            editExpe.setEmpresa(expe.getEmpresa());
            editExpe.setUbicacion(expe.getUbicacion());
            editExpe.setPuesto(expe.getPuesto());
            editExpe.setPeriodo(expe.getPeriodo());
            editExpe.setActividades(expe.getActividades());

            return experienciaRepo.save(editExpe);
        });
        //.orElseGet(() -> {
        //  acercade.setId(id);
        //  return acercadeRepo.save(acercade);
        //});
    }


    public Boolean existsExperiencia(Long id){
        try {
            experienciaRepo.findById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }


}
