package br.com.alexandre.Desafio.Back.end.validation;


import br.com.alexandre.Desafio.Back.end.constraints.PlacaDeCarro;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PlacaDeCarroValidation implements ConstraintValidator<PlacaDeCarro, String> {
    @Override
    public void initialize(PlacaDeCarro constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String placa = value == null ? "" : value;
        return placa.matches("[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}");
    }
}
