package com.example.registration.service;

import com.example.registration.exception.CustomerAlreadyRegisteredException;
import com.example.registration.model.Role;
import com.example.registration.model.User;
import com.example.registration.repository.RoleRepository;
import com.example.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService  implements UserDetailsService {

   private final PasswordEncoder encoder ;
   private final     UserRepository userRepository;
   private final  RoleRepository roleRepository;



    public void register(User user) throws CustomerAlreadyRegisteredException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }
        Set<Role> roles=new HashSet<>();
        roles.add(roleRepository.findById(1).get());
        user.setRoles(roles);
         user.setPassword(encoder.encode(user.getPassword()));
         user.setEnabled(true);
        userRepository.save(user);
    }
    public User findByEmail(String email){
      return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;    }
}
