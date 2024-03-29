package com.micosoft.taskapp_backend.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUsers(User user) {
        boolean userExists=userRepository.existsById(user.getUserId());
        boolean usernameExists=userRepository.findByUsernameIgnoreCase(user.getUsername()).isPresent();
        boolean emailExists=userRepository.findByEmailIgnoreCase(user.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("user already exists");
        } else if (usernameExists) {
            throw new IllegalStateException("username already exist");
        } else if (emailExists) {
            throw new IllegalStateException("email already exists");
        }else {
            return userRepository.save(user);
        }

    }

    public Optional<User> getSingleUser(String id) {
        boolean userExists=userRepository.existsById(id);
        if (!userExists){
            throw new IllegalStateException("User does not exist");
        }else {
            return userRepository.findById(id);
        }
    }

    public String deleteUser(String id) {
        boolean userExists=userRepository.existsById(id);
        if (!userExists){
            throw new IllegalStateException("User does not exist");
        }else {
            userRepository.deleteById(id);
            return "User successfully deleted";
        }
    }

    public User updateUser(String id, User user) {
        Optional<User> userItem= userRepository.findById(id);
        boolean checkingByUserName=userRepository.findByUsernameIgnoreCase(user.getUsername()).isPresent();
        boolean checkUserByEmail=userRepository.findByEmailIgnoreCase(user.getEmail()).isPresent();
        if (!userItem.isPresent()){
            throw new IllegalStateException("User does not exist");
//            CheckingByUserName
        } else if (!user.getUsername().isEmpty()&&
                !user.getUsername().equals(userItem.get().getUsername())&&
                !checkingByUserName
        ) {
            userItem.get().setUsername(user.getUsername());
        }
//        password checking and changing
        if (!user.getPassword().isEmpty()&&
                !user.getPassword().equals(userItem.get().getPassword())
        ) {
            userItem.get().setPassword(user.getPassword());
        }
//        checking by email
        if (!user.getEmail().isEmpty()&&
                !user.getEmail().equals(userItem.get().getEmail())&&
                !checkUserByEmail
        ) {
            userItem.get().setEmail(user.getEmail());
        }
        return userRepository.save(userItem.get());

    }
}
