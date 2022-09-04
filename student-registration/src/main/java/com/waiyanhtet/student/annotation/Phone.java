package com.waiyanhtet.student.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneConstraint.class)
public @interface Phone {

	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
