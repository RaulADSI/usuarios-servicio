package com.tiendaonline.usuariosservicio.service;

import com.tiendaonline.usuariosservicio.entity.User;
import com.tiendaonline.usuariosservicio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public User registerUsers(User user){
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
