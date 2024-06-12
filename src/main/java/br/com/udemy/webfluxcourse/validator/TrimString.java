package br.com.udemy.webfluxcourse.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { TrimStringValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrimString {

	String message() default "field can not have blank space at the beginning or the end";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
