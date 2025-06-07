package com.sneakersEcomerce.sneakersEcomerceBackend.user;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<UserModel,Integer> {
    public UserService(UserRepository userRepository){
        super(userRepository);
    }
}
