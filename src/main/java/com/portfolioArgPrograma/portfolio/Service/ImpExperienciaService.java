/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Service;

import com.portfolioArgPrograma.portfolio.Entity.Experiencia;
import com.portfolioArgPrograma.portfolio.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose_
 */
@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
    IExperienciaRepository iexperienciaRepository;
   public List <Experiencia> list(){
   
   return iexperienciaRepository.findAll();
   }
   
   public Optional <Experiencia> getOne(int id){
   
       return iexperienciaRepository.findById(id);
   }
   
     public Optional <Experiencia> getByNombreExperiencia(String nombreExperiencia){
   
       return iexperienciaRepository.findByNombreExperiencia(nombreExperiencia);
   }
     
     public void save(Experiencia experiencia){
         iexperienciaRepository.save(experiencia);
     }
     
     public void delete(int id){
     
     iexperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
     
     return iexperienciaRepository.existsById(id);
     }
     
       public boolean existsByNombreExperienca(String nombreExperiencia){
     
     return iexperienciaRepository.existsByNombreExperiencia(nombreExperiencia);
     }
}
