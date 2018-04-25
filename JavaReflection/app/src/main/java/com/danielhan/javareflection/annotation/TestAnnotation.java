package com.danielhan.javareflection.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author DanielHan
 * @date 2018/4/25
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int id();

    String msg();
}
