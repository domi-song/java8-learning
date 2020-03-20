package com.domi.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @program: java8-learning->LambdaExpression
 * @description:
 * @author: Domi·Song
 * @create: 2020-02-16 10:40
 **/
public class LambdaExpression {

    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>(){

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();

        list.sort(byColor);

        Comparator<Apple> byColor2 = (Apple o1 ,Apple  o2) -> o1.getColor().compareTo(o2.getColor());

        Consumer<String> stringConsumer = (String s) -> s.length();

        Function<String, Integer> fLambda = s -> s.length();

        Predicate<Apple> p = a -> a.getColor().equals("green");

        Function<Apple , Boolean> f = a -> a.getColor().equals("green");

        Runnable r = () -> {};
    }
}
