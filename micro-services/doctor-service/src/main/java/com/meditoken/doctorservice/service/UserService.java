package com.meditoken.doctorservice.service;

import com.meditoken.doctorservice.model.User;
import com.meditoken.doctorservice.repository.UserRepository;
import com.meditoken.doctorservice.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            return userRepository.findByUserId(userId);
        }
        else {
            throw new IllegalStateException("User with ID" +
                    userId + " does not exist.");
        }
    }

    public User createNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("User already taken!");
        }
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateStudent(Long userid, User user) {
        Optional<User> userOptional = userRepository.findById(userid);
        if(userOptional.isPresent()){
            User _user = userOptional.get();
            _user.setEmail(user.getEmail());
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setPassword(user.getPassword());
            _user.setCity(user.getCity());
            _user.setCountry(user.getCountry());
            _user.setState(user.getState());

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseTemplate login(User user) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            User _user = userOptional.get();
            if(user.getPassword().equals(_user.getPassword())){
                responseTemplate.setUserId(_user.getUserId());
                responseTemplate.setUsername(_user.getFirstName());
                responseTemplate.setValid(true);
                return responseTemplate;
            }
        }
        return null;
    }
}
