package com.cydeo.streampractice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    private Long id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Country country;

    @Override
    public String toString() {
        return "{" + id + ", " + streetAddress + ", " + postalCode + ", " + city + ", " + stateProvince + ", " + country.getCountryName() + "}";
    }

}
