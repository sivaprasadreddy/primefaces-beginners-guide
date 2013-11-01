package com.packtpub.techbuzz.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.primefaces.validate.bean.ClientConstraint;

@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=CreditCardConstraintValidator.class)
@ClientConstraint(resolvedBy=CreditCardClientValidationConstraint.class)
@Documented
public @interface CreditCard 
{
    
    String message() default "{com.packtpub.techbuzz.validation.creditcard.invalid}";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
