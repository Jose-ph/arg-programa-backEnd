/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.demo.Security.Repository;

import com.portfolio.demo.Security.Entity.Rol;
import com.portfolio.demo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose_
 */
@Repository
public interface InterfaceRolRepository extends JpaRepository<Rol, Integer> {
  Optional <Rol>  findByRolNombre(RolNombre rolNombre);
    
}
