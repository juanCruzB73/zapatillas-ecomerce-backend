package com.sneakersEcomerce.sneakersEcomerceBackend.user;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<UserModel, Integer> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/active")
    public List<UserModel> getActiveUsers() {
        return userService.getActiveUsers();
    }
}

