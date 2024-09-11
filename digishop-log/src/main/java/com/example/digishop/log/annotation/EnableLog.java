package com.example.digishop.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.example.digishop.log.annotation.properties.LogProperties;

/**
 * 是否开启日志组件
 *
 * @author SunTao
 * @since 2022-06-20
 */
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Import({ LogProperties.class })
public @interface EnableLog {
}