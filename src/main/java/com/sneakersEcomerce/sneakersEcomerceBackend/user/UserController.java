package com.sneakersEcomerce.sneakersEcomerceBackend.user;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<UserModel,Integer> {
    public UserController(UserService userService){
        super(userService);
    }

}
