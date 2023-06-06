package com.teamresourceful.resourcefulintegration.utils;

import org.intellij.lang.annotations.Pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.CLASS)
@Target({ METHOD, FIELD, PARAMETER, LOCAL_VARIABLE, ANNOTATION_TYPE })
@Pattern("[a-z0-9/._-]*|[a-z0-9._-]*:[a-z0-9/._-]*")
public @interface Identifier {
}
