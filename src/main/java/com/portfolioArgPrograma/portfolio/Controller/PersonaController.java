/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Controller;

import com.portfolioArgPrograma.portfolio.Entity.Persona;
import com.portfolioArgPrograma.portfolio.Interface.IPersonaService;
import java.util.List;
//import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose_
 */
@RestController
public class PersonaController {
    
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("persona/get")
    public List <Persona> getPersona(){
    
    return ipersonaService.getPersona();
    
    }
    
    @PostMapping("persona/crear") //Recibe objeto persona
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Persona creada con èxito";
    }
    
    @DeleteMapping ("persona/borrar/{id}")

    public String deletePersona(@PathVariable Long id){
    
    ipersonaService.deletePersona(id);
    return "Persona borrada con èxito";
    
    }

    
    @PutMapping("persona/editar/{id}")//Esto puede ser mejor con requestbody
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre")String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("imgPerfil") String nuevoImgPerfil,
            @RequestParam("imgBanner") String nuevoImgBanner,
            @RequestParam("about") String nuevoAbout,
            @RequestParam("ocupacion") String nuevoOcupacion){
    
    
    Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImgPerfil(nuevoImgPerfil);
        persona.setImgBanner(nuevoImgBanner);
        persona.setAbout(nuevoAbout);
        persona.setOcupacion(nuevoOcupacion);
        
        ipersonaService.savePersona(persona);
        
        return persona;
        
    
    
    }
   
    
    

}
