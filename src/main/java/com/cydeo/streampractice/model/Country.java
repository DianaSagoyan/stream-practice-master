package com.cydeo.streampractice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    private String id;
    private String countryName;
    private Region region;

    @Override
    public String toString() {
        return "{" + id + ", " + countryName + ", " + region.getRegionName() + "}";
    }

}
