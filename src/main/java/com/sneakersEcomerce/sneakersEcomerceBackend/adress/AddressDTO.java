package com.sneakersEcomerce.sneakersEcomerceBackend.adress;

import java.util.Optional;

public record AddressDTO(
        Optional<Integer>addresId,
         String province,
        String city,
        String street,
        String streetNumber,
        Integer userId
) {
}
