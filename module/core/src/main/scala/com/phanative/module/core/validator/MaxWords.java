package com.phanative.module.core.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = WordValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface MaxWords {

    String message() default "{com.phanative.seam.validation.constraints.MaxWords.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int length();

}