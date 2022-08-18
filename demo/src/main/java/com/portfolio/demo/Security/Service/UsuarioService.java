/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Security.Service;

import com.portfolio.demo.Security.Entity.Usuario;
import com.portfolio.demo.Security.Repository.InterfaceUsuarioRepository;
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
public class UsuarioService {
    @Autowired
    InterfaceUsuarioRepository interfaceusuarioRepository;
    
    public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
    
    return interfaceusuarioRepository.findByNombreUsuario(nombreUsuario);
    
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
       
        return interfaceusuarioRepository.existByNombreUsuario(nombreUsuario);
    }
   
      public boolean existsByEmailo(String email){
       
        return interfaceusuarioRepository.existByEmail(email);
    }
   
      public void save(Usuario usuario){
          
          interfaceusuarioRepository.save(usuario);
      }
    
    
}
