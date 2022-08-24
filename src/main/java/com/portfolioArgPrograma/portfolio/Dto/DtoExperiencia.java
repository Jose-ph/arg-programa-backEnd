/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioArgPrograma.portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jose_
 */

@Getter @Setter
public class DtoExperiencia {
    
    @NotBlank
     private String nombreExperiencia;
    private String descripcionExperiencia;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExperiencia, String descripcionExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
    }
    
    
}
