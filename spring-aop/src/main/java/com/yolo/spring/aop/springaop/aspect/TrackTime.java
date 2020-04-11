package com.yolo.spring.aop.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Create Custom Annotations

@Target(ElementType.METHOD)//want to use this annotation on methods only
@Retention(RetentionPolicy.RUNTIME)//this annotation will be available in RunTime only.
public @interface TrackTime {

}
