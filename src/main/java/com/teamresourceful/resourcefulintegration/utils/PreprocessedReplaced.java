package com.teamresourceful.resourcefulintegration.utils;

import java.lang.annotation.*;

/**
 * This annotation is used to mark a class or method as being replaced by a preprocessor.
 * <br>
 * This is purely for documentation purposes and does not affect the code in any way.
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PreprocessedReplaced {
}
