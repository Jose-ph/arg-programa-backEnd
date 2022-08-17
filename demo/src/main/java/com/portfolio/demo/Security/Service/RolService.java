/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Security.Service;

import com.portfolio.demo.Security.Entity.Rol;
import com.portfolio.demo.Security.Enums.RolNombre;
import com.portfolio.demo.Security.Repository.InterfaceRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose_
 */
@Service
@Transactional
public class RolService {
    @Autowired
    InterfaceRolRepository interfaceRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return interfaceRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        interfaceRolRepository.save(rol);
    }
}
