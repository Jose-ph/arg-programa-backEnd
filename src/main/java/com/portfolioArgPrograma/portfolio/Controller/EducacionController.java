/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Controller;

import com.portfolioArgPrograma.portfolio.Dto.DtoEducacion;
import com.portfolioArgPrograma.portfolio.Entity.Educacion;
import com.portfolioArgPrograma.portfolio.Service.ImpEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<Educacion>> list(){
    
    List<Educacion> list = impEducacionService.list();
    return new ResponseEntity(list, HttpStatus.OK);
    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable("id") int id){
    
     if(!impEducacionService.existsById(id))
            
            return new ResponseEntity(new Mensaje("id no existe"), HttpStatus.NOT_FOUND);
   impEducacionService.delete(id);
    
    return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    
    
    }
    
     @PostMapping("/create")
   public ResponseEntity <?> create(@RequestBody DtoEducacion dtoEducacion){
       
       if(StringUtils.isBlank(dtoEducacion.getNombreEducacion()))
           return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
       if(impEducacionService.existsByNombreEducacion(dtoEducacion.getNombreEducacion()))
           return new ResponseEntity(new Mensaje("Experiencia existente"),HttpStatus.BAD_REQUEST);
       
       Educacion educacion = new Educacion(dtoEducacion.getNombreEducacion(),dtoEducacion.getDescripcionEducacion());
       impEducacionService.save(educacion);
       return new ResponseEntity(new Mensaje ("Experiencia Agregada correctamente"), HttpStatus.OK);
   }
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
       @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion ){
    
    if(!impEducacionService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        
    if(impEducacionService.existsByNombreEducacion(dtoEducacion.getNombreEducacion())&& impEducacionService.getByNombreEducacion(dtoEducacion.getNombreEducacion()).get().getId() != id )
        return new ResponseEntity(new Mensaje("Educacion ya existente"), HttpStatus.BAD_REQUEST);
    
    if(StringUtils.isBlank(dtoEducacion.getNombreEducacion()))
        return new ResponseEntity(new Mensaje("Este campo es obligatorio"),HttpStatus.BAD_REQUEST);
    
    Educacion educacion = impEducacionService.getOne(id).get();
    educacion.setNombreEducacion(dtoEducacion.getNombreEducacion());
    educacion.setDescripcionEducacion(dtoEducacion.getDescripcionEducacion());
    
    impEducacionService.save(educacion);
    
    return new ResponseEntity(new Mensaje("Educacion actualizada"),HttpStatus.OK);
    
        
    }
    
}
