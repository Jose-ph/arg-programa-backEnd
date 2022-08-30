/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Controller;


import com.portfolioArgPrograma.portfolio.Dto.DtoExperiencia;
import com.portfolioArgPrograma.portfolio.Entity.Experiencia;
import com.portfolioArgPrograma.portfolio.Service.ImpExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose_
 */
@RestController
@RequestMapping("experienciaLaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ImpExperienciaService impexperienciaService;
    @GetMapping("/lista")
    public ResponseEntity <List<Experiencia>> list(){
        List<Experiencia> list = impexperienciaService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    
    }
 
    @PostMapping("/create")
   public ResponseEntity <?> create(@RequestBody DtoExperiencia dtoExperiencia){
       
       if(StringUtils.isBlank(dtoExperiencia.getNombreExperiencia()))
           return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
       if(impexperienciaService.existsByNombreExperienca(dtoExperiencia.getNombreExperiencia()))
           return new ResponseEntity(new Mensaje("Experiencia existente"),HttpStatus.BAD_REQUEST);
       
       Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreExperiencia(),dtoExperiencia.getDescripcionExperiencia());
       impexperienciaService.save(experiencia);
       return new ResponseEntity(new Mensaje ("Experiencia Agregada correctamente"), HttpStatus.OK);
   }
   
   @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impexperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impexperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
   
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia ){
    
    if(!impexperienciaService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        
    if(impexperienciaService.existsByNombreExperienca(dtoExperiencia.getNombreExperiencia())&& impexperienciaService.getByNombreExperiencia(dtoExperiencia.getNombreExperiencia()).get().getId() != id )
        return new ResponseEntity(new Mensaje("Esta experiencia ya existe"), HttpStatus.BAD_REQUEST);
    
    if(StringUtils.isBlank(dtoExperiencia.getNombreExperiencia()))
        return new ResponseEntity(new Mensaje("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
    
    Experiencia experiencia = impexperienciaService.getOne(id).get();
    experiencia.setNombreExperiencia(dtoExperiencia.getNombreExperiencia());
    experiencia.setDescripcionExperiencia(dtoExperiencia.getDescripcionExperiencia());
    
    impexperienciaService.save(experiencia);
    
    return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    
        
    }
    
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable("id") int id){
    
    if(!impexperienciaService.existsById(id))
            
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
    impexperienciaService.delete(id);
    
    return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    
    
    
}
