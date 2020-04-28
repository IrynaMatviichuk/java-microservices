package com.euclient.apartmentsService;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Min(1) @Max(10)
    private int numberOfRooms;

    @NotNull @Min(1)
    private int floorNumber;

    @NotNull @Min(1)
    private int totalFloorsNumber;

    @NotNull @Min(20)
    private float square;

    @NotNull
    @Size(min=1, max=50)
    private String wallType;

    @NotNull
    @Size(min=1, max=50)
    private String heatingType;

    @NotNull
    @Size(min=1, max=50)
    private String apartmentCondition;

    @NotNull
    @Size(min=1, max=50)
    private String streetName;

    @NotNull
    @Size(min=1, max=5)
    private String buildingNumber;

    @NotNull @Min(1)
    private int apartmentNumber;

}
