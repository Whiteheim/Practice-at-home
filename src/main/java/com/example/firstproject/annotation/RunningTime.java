package com.example.firstproject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // @ (annotation) 적용 대상
@Retention(RetentionPolicy.RUNTIME) // annotation 유지기간
public @interface RunningTime {
}
