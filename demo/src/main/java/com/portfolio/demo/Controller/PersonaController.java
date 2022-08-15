/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Controller;

import com.portfolio.demo.Entity.Persona;
import com.portfolio.demo.Interface.InterfacePersonaService;
import java.util.List;
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
    @Autowired InterfacePersonaService interfacepersonaService;
    
    @GetMapping("personas/get")
    public List<Persona> getPersona(){
        return interfacepersonaService.getPersona();
    
    }
    
    @PostMapping("/personas/create")
    public String createPersona(@RequestBody Persona persona){
        interfacepersonaService.savePersona(persona);
        return "Persona creada con èxito";
    
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interfacepersonaService.deletePersona(id);
        return "Persona eliminada con èxito";
    
    }
    
    @PutMapping("/personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id,
             @RequestParam("nombre") String nuevoNombre, 
             @RequestParam("apellido") String nuevoApellido,
             @RequestParam("img") String nuevaImg){
    Persona persona = interfacepersonaService.findPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevaImg);
    
    interfacepersonaService.savePersona(persona);
    return persona;
    }
}
