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
public class DtoEducacion {
    @NotBlank
     private String nombreEducacion;
     @NotBlank
    private String descripcionEducacion;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEducacion, String descripcionEducacion) {
        this.nombreEducacion = nombreEducacion;
        this.descripcionEducacion = descripcionEducacion;
    }
    
     
}
