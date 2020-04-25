package com.euclient.apartmentsService;

import com.euclient.exceptions.ApartmentDoesNotExistException;
import com.euclient.exceptions.ValidationException;
import com.euclient.responses.ApartmentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ApartmentsController {

    @Value("${eureka.instance.instance-id}")
    private String serviceInstanceId;

    @Autowired
    private ApartmentsService apartmentsService;

    @GetMapping(value = "/test")
    @ResponseBody
    public Apartment test() {
        Apartment apartments = new Apartment();
        return apartments;
    }

    @GetMapping(value = "/apartments/all")
    @ResponseBody
    public ApartmentsResponse findAll() {
        return new ApartmentsResponse(serviceInstanceId, apartmentsService.findAll());
    }

    @PostMapping(value = "/apartments/add")
    @ResponseBody
    public Apartment add(@Valid @RequestBody Apartment apartments, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            throw new ValidationException(errors);
        }
        return apartmentsService.add(apartments);
    }

    @PostMapping("/apartments/update")
    public Apartment updateById(@Valid @RequestBody Apartment apartments, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            throw new ValidationException(errors);
        }

        if (!apartmentsService.existsById(apartments.getId())) {
            throw new ApartmentDoesNotExistException();
        }

        return this.apartmentsService.updateById(apartments);
    }

    @GetMapping("/apartments/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        if (!apartmentsService.existsById(id)) {
            throw new ApartmentDoesNotExistException();
        }
        this.apartmentsService.deleteById(id);
        return "Successfully deleted apartment with id=" + id;
    }
}
