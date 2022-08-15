/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.Persona;
//import javax.validation.constraints.NegativeOrZero.List;
import java.util.List;

/**
 *
 * @author jose_
 */


public interface InterfacePersonaService {
    //Get lista persona
    public List <Persona> getPersona();
    
    //Save persona
    
    public void savePersona(Persona persona);
            
   //Delete persona por Id
           public void deletePersona(Long id); 
           
   // Search persona por id
           
           public Persona findPersona(Long id);
           
}
