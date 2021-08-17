package com.example.connectionwithdatabase.core.repository;

import com.example.connectionwithdatabase.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}
//Se coloca nuestra clase entidad y el tipo de dato de nuestra clave principal