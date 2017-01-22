package com.alexander.config.annotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * Created by alex on 08.01.2017.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
public @interface RestEndpoint
{
    String value() default "";
}
