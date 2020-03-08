package com.euclient.apartmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApartmentsController {

    @Value("${eureka.instance.instance-id}")
    private String serviceInstanceId;

    @Autowired
    private ApartmentsService apartmentsService;

    @GetMapping("/apartments/all")
    public Response findAll() throws SQLException {
//        return ResponseEntity.ok(apartmentsService.findAll());
//        System.out.println("\n\n\n" + serviceInstanceId);
//        return apartmentsService.findAll();
        return new Response(serviceInstanceId, apartmentsService.findAll());
    }

    @PostMapping(value = "/apartments/add", produces = "application/json; charset=utf-8")
    public Apartments add(@Valid @RequestBody Apartments apartments) throws SQLException {
//        try {
//            Apartments createdApartment = apartmentsService.add(apartments);
//            return ResponseEntity.ok("Successfully added apartment: " + createdApartment);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                    .body(e.getMessage());
//        }
        return apartmentsService.add(apartments);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException.class)
    public Map<String, String> handleValidationExceptions(WebExchangeBindException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMassage = error.getDefaultMessage();
            errors.put(fieldName, errorMassage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DecodingException.class)
    public Map<String, String> handleDecodingException(DecodingException ex) {
        Map<String, String> errors = new HashMap<>();
        String errorMessage = ex.getMessage();
        errors.put("DecodingError", errorMessage);
        return errors;
    }

    @GetMapping("/apartments/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws SQLException {
        try {
            apartmentsService.deleteById(id);
            return ResponseEntity.ok("Deleted apartment with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/apartments/update")
    public ResponseEntity<String> updateById(@RequestBody Apartments apartments) throws SQLException {
        try {
            if (apartmentsService.existsById(apartments.getId())) {
                Apartments updatedApartment = apartmentsService.updateById(apartments);
                return ResponseEntity.ok("Successfully updated apartment: " + updatedApartment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                        .body("There is no entity with id=" + apartments.getId() + ". It is impossible to update an nonexistent entity");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(e.getMessage());
        }
    }
}
