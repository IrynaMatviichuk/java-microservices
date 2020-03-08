//package com.euclient.apartmentsService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;
//import java.util.Set;
//
//@Service
//public class ApartmentsValidator implements org.springframework.validation.Validator {
//
//    @Autowired
//    private Validator validator;
//
//    @Override
//    public boolean supports(Class classToValidate) {
//        return Apartments.class.equals(classToValidate);
//    }
//
//    @Override
//    public void validate(Object object, Errors errors) {
//        Set<ConstraintViolation<Object>> validated = validator.validate(object);
//        for (ConstraintViolation<Object> constraintViolation : validated) {
//            String propertyPath = constraintViolation.getPropertyPath().toString();
//            String message = constraintViolation.getMessage();
//            errors.rejectValue(propertyPath, "", message);
//        }
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wallType", "wallType.empty");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heatingType", "heatingType.empty");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apartmentCondition", "apartmentCondition.empty");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetName", "streetName.empty");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "buildingNumber", "buildingNumber.empty");
//
////        Apartments apartments = (Apartments) object;
////        System.out.println("\n\n\nvalidator");
////        System.out.println(apartments.getNumberOfRooms());
////        if (apartments.getNumberOfRooms() < 1) {// || apartments.getFloorNumber() < 1 || apartments.getTotalFloorsNumber() < 1 || apartments.getApartmentNumber() < 1) {
////            System.out.println("worked");
////            errors.rejectValue("numberOfRooms", "numberOfRooms can't be less than 1");
////        }
//
////        if (apartments.getFloorNumber() < 1) {
////            errors.rejectValue("floorNumber", "floorNumber can't be less than 1");
////        }
//    }
//}
