/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jose_
 */
@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message="Longitud incorrecta" )
    private String nombre;
    
      @NotNull
    @Size(min=1, max=50, message="Longitud incorrecta" )
    
    private String apellido;
      
        // @NotNull prueba sin img
    @Size(min=1, max=2850, message="Longitud incorrecta" )
    
    private String img;
    
       // @NotNull prueba sin img
    @Size(min=1, max=2850, message="Longitud incorrecta" )
    
    private String img_header;
    
     // @NotNull prueba sin img
    @Size(min=1, max=2850, message="Longitud incorrecta" )
    
    private String img_perfil;
    
        @NotNull
    @Size(min=1, max=300, message="Longitud incorrecta" )
    
    private String acerca;
    
               @NotNull
    @Size(min=1, max=300, message="Longitud incorrecta" )
    
    private String ocupacion;
}
