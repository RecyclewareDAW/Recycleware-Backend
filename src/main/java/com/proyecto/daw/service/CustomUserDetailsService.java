package com.proyecto.daw.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.daw.model.User;
import com.proyecto.daw.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)

    //NOTA IMPORTANTE: aun que parezca contradictorio, correo y username son lo mismo por que son la string usada para identificar al ususario en la bd
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        User user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + correo);
        }

        ArrayList<String> rolesArray = new ArrayList<>();
        rolesArray.add("ADMIN");
        rolesArray.add("EMPRESA");
        rolesArray.add("PARTICULAR");

        UserDetails userH2 = User
                .withUsername(user.getCorreo())
                .password(user.getPassword())
                .roles(rolesArray.toArray(new String[rolesArray.size()]))
                .build();

        if (userH2!=null) {
            System.out.println();
            System.out.println("Username:"+userH2.getUsername());
            System.out.println("Password:"+userH2.getPassword());
            System.out.println("Roles...:"+rolesArray.toArray().toString());
        } 
        
        return userH2;

    }

}
