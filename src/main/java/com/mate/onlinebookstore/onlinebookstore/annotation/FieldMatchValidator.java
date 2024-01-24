package com.mate.onlinebookstore.onlinebookstore.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Object firstFieldValue = value.getClass().getDeclaredField(firstFieldName).get(value);
            Object secondFieldValue = value.getClass().getDeclaredField(secondFieldName).get(value);
            return firstFieldValue != null && firstFieldValue.equals(secondFieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle exceptions appropriately
            return false;
        }
    }
}
