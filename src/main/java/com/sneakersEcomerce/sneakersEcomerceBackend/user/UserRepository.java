package com.sneakersEcomerce.sneakersEcomerceBackend.user;


import com.sneakersEcomerce.sneakersEcomerceBackend.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<UserModel,Integer> {
    Optional<UserModel>findByUsername(String username);
    List<UserModel> findByActiveTrue();
}
