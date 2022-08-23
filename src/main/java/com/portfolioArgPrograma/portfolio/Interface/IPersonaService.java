/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Interface;

import com.portfolioArgPrograma.portfolio.Entity.Persona;
import java.util.List;



/**
 *
 * @author jose_
 */
public interface IPersonaService {
    //Trae persona y la muestra en lista
    public List <Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
