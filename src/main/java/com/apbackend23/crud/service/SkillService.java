package com.apbackend23.crud.service;

import com.apbackend23.crud.entity.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apbackend23.crud.repository.SkillRepository;

/**
 *
 * @author HCanestraro
 */

@Service
public class SkillService  {

    @Autowired
    public SkillRepository skillRepo;


    public List<Skill> verSkills (){
        return skillRepo.findAll();
    }


    public void crearSkill (Skill sk){
        skillRepo.save(sk);
    }


    public void borrarSkill (Long id){
        skillRepo.deleteById(id);
    }


    public Skill buscarSkill(Long id){
        return skillRepo.findById(id).orElse(null);
    }


    public void editarSkill (Long id, Skill sk){
        skillRepo.findById(id).map( editSk -> {
            editSk.setTecnologia(sk.getTecnologia());
            editSk.setImagen(sk.getImagen());

            return skillRepo.save(editSk);
        });
        //.orElseGet(() -> {
        //  acercade.setId(id);
        //  return acercadeRepo.save(acercade);
        //});
    }


    public Boolean existsSkill(Long id){
        try {
            skillRepo.findById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }




}
