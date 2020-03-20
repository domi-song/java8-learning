package com.domi.java8;

/**
 * Created by Domi on 2020/03/20.
 */
@FunctionalInterface
public interface ThreeFunction<T ,U ,K ,R> {

    R apply(T t ,U u ,K k);
}
