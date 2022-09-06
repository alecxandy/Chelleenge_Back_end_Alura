package br.com.alexandre.Desafio.Back.end.constraints;

import br.com.alexandre.Desafio.Back.end.validation.PlacaDeCarroValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlacaDeCarroValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  PlacaDeCarro {

    String message() default "Placa de carro invalid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
