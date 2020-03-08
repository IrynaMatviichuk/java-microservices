package com.euclient.apartmentsService;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response {
    String serviceInstanceId;
    List<Apartments> apartments;
}
