package uk.jackbergus.withReflection.model;

import java.lang.annotation.Retention;

@Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface ManyToMany {
    Class<?> targetClass();
}
