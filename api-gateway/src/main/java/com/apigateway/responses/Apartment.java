package com.apigateway.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Apartment {
    private Long id;
    private int numberOfRooms;
    private int floorNumber;
    private int totalFloorsNumber;
    private float square;
    private String wallType;
    private String heatingType;
    private String apartmentCondition;
    private String streetName;
    private String buildingNumber;
    private int apartmentNumber;
}
