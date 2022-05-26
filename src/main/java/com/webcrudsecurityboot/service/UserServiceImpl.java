package com.webcrudsecurityboot.service;

import com.webcrudsecurityboot.model.User;
import com.webcrudsecurityboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> fetchUserList() {
        //return userRepository.getAllUsers();
        return (List<User>) userRepository.findAll();
    }

//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);//show(id);
//    }

    @Override
    public User show (Long id)  {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser, Long id) {
//        if(!updatedUser.getPassword().equals(userRepository.findById(updatedUser.getId()).getPassword())) {
//            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//        }
        User user = userRepository.findById(id).get();

        if(Objects.nonNull(updatedUser.getId()) && updatedUser.getId() != 0.0) {
            user.setId(updatedUser.getId());
        }

        if(Objects.nonNull(updatedUser.getName()) && !"".equalsIgnoreCase(updatedUser.getName())) {
            user.setName(updatedUser.getName());
        }

        if(Objects.nonNull(updatedUser.getSurName()) && !"".equalsIgnoreCase(updatedUser.getSurName())) {
            user.setSurName(updatedUser.getSurName());
        }

        if(Objects.nonNull(updatedUser.getEmail()) && !"".equalsIgnoreCase(updatedUser.getEmail())) {
            user.setEmail(updatedUser.getEmail());
        }

        if(Objects.nonNull(updatedUser.getAge()) && updatedUser.getAge() != 0) {
            user.setAge(updatedUser.getAge());
        }

        if(Objects.nonNull(updatedUser.getRoles()) && !updatedUser.getRoles().isEmpty()) {
            user.setRoles(updatedUser.getRoles());
        }

        if(Objects.nonNull(updatedUser.getPassword()) && !"".equalsIgnoreCase(updatedUser.getPassword())) {
//            if(!(user.getPassword().equals(updatedUser.getPassword()))) {
//                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//            }
        }
        saveUser(updatedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        if(user == null) {
            throw new UsernameNotFoundException("User " + name + " not found!");
        }
        return user;
    }
}
