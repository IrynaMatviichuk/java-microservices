package com.euclient.apartmentsService;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Apartments implements Serializable {

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull @Past
    private LocalDate constructionYear;

    @NotNull @NotEmpty
    @Size(min=1, max=50)
    private String wallType;

    @NotNull @NotEmpty
    @Size(min=1, max=50)
    private String heatingType;

    @NotNull @NotEmpty
    @Size(min=1, max=50)
    private String apartmentCondition;

    @NotNull @NotEmpty
    @Size(min=1, max=50)
    private String streetName;

    @NotNull @NotEmpty
    @Size(min=1, max=5)
    private String buildingNumber;

    @NotNull @Min(1)
    private int apartmentNumber;

}
