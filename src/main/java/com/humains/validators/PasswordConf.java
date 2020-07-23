package com.humains.validators;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.TYPE_USE, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE } )
@Constraint(validatedBy = CustumePassword.class)
@Documented
public @interface PasswordConf {
    String message() default "passwords non identique !";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
