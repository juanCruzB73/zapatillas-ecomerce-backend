package com.sneakersEcomerce.sneakersEcomerceBackend.user;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericServiceImpl<UserModel,Integer> {

    @Autowired UserRepository userRepository;
    public UserService(UserRepository userRepository){
        super(userRepository);
    }

    public List<UserModel> getActiveUsers() {
        return userRepository.findByActiveTrue();
    }

    @Override
    public UserModel update(Integer id, UserModel userInput) {
        UserModel existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userInput.getName() != null) {
            existing.setName(userInput.getName());
        }
        if (userInput.getLastname() != null) {
            existing.setLastname(userInput.getLastname());
        }
        if (userInput.getUsername() != null) {
            existing.setUsername(userInput.getUsername());
        }
        if (userInput.getDni() != null) {
            existing.setDni(userInput.getDni());
        }
        if (userInput.getEmail() != null) {
            existing.setEmail(userInput.getEmail());
        }
        if (userInput.getPassword() != null) {
            existing.setPassword(userInput.getPassword());
        }
        if (userInput.getUserType() != null) {
            existing.setUserType(userInput.getUserType());
        }
        if (userInput.getActive() != null) {
            existing.setActive(userInput.getActive());
        }
        if (userInput.getAddresses() != null) {
            existing.setAddresses(userInput.getAddresses());
        }

        return userRepository.save(existing);
    }
}
