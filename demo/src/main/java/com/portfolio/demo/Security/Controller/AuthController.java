/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Security.Controller;

import com.portfolio.demo.Security.Dto.JwtDto;
import com.portfolio.demo.Security.Dto.LoginUsuario;
import com.portfolio.demo.Security.Dto.NuevoUsuario;
import com.portfolio.demo.Security.Entity.Rol;
import com.portfolio.demo.Security.Entity.Usuario;
import com.portfolio.demo.Security.Enums.RolNombre;
import com.portfolio.demo.Security.Service.RolService;
import com.portfolio.demo.Security.Service.UsuarioService;
import com.portfolio.demo.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose_
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
     @Autowired
     AuthenticationManager authenticationmanager;
     @Autowired
     UsuarioService usuarioService;
     @Autowired
     RolService rolService;
     @Autowired
     JwtProvider jwtProvider;
     
     @PostMapping("/nuevo")
     
     public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
         
         if ( bindingResult.hasErrors())
             return new ResponseEntity(new Mensaje ("Campos incorrectos o email invàlido"), HttpStatus.BAD_REQUEST);
         
         if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
             return new ResponseEntity(new Mensaje("Nombre de Usuario existente"),HttpStatus.BAD_REQUEST);
         
         if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
             return new ResponseEntity(new Mensaje("Email existente"),HttpStatus.BAD_REQUEST);
         
     
         Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
         
         Set<Rol> roles = new HashSet<>();
         roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
         
         
         if(nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROL_ADMIN).get());
         usuario.setRoles(roles);
         usuarioService.save(usuario);
         
         
         return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
             
         
         
     }
     
        @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
