package com.example.connectionwithdatabase.core.service;

import com.example.connectionwithdatabase.core.entity.User;
import com.example.connectionwithdatabase.core.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//@Log4j2
@Service
public class UserServiceIml implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional (readOnly = true)
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        //log.info("Guardando cliente");
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
