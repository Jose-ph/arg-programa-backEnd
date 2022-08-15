/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Persona;
import com.portfolio.demo.Interface.InterfacePersonaService;
import com.portfolio.demo.Repository.InterfacePersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose_
 */
@Service
public class ImplementationPersonaService implements InterfacePersonaService  {
    
    @Autowired InterfacePersonaRepository interfacepersonaRepository;

    @Override
    public List<Persona> getPersona() {
       List<Persona> persona = interfacepersonaRepository.findAll();
       return persona;
    }

    @Override
    public void savePersona(Persona persona) {
         interfacepersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        interfacepersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona =  interfacepersonaRepository.findById(id).orElse(null);
      return persona;
    }
    
}
