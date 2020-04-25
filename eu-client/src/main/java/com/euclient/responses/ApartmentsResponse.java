package com.euclient.responses;

import com.euclient.apartmentsService.Apartment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApartmentsResponse {
    String serviceInstanceId;
    List<Apartment> apartments;
}
