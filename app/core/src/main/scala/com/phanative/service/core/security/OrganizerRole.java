package com.phanative.service.core.security;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jboss.seam.security.annotations.SecurityBindingType;

@SecurityBindingType
@Target({FIELD, METHOD, TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface OrganizerRole {
}
