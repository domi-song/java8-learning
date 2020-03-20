package com.domi.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Domi on 2020/03/06.
 */
public class MethodReference {
    public static void main(String[] args) {
        /*Consumer<String> consumer = (s) -> System.out.println(s);
        testConsumer(consumer ,"Hello World!");*/

        /*testConsumer(s -> System.out.println(s) ,"Hello Blue!");
        testConsumer(System.out :: println ,"Hello Coffee.");*/

        List<Apple> list = Arrays.asList(new Apple("Green" ,120) ,new Apple("abc" ,123) ,new Apple("Red" ,123));
        System.out.println(list);
        // list.sort((a1 ,a2) -> { return a1.getColor().compareTo(a2.getColor());}); 可以写为：
        // list.sort((a1 ,a2) -> { a1.getColor().compareTo(a2.getColor())); 写为：
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);

        list.stream().forEach(s-> System.out.println(s));
        System.out.println("------------------");
        list.stream().forEach(System.out :: println);

        System.out.println("------------------");
        int parseInt = Integer.parseInt("123");
        System.out.println(parseInt);

        Function<String ,Integer> f = Integer :: parseInt;
        Integer result = f.apply("123");
        System.out.println(result);


        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character c = f2.apply("hello", 2);
        System.out.println(c);

        String string = new String("hello");
        Function<Integer, Character> f3 = string::charAt;
        Character c2 = f3.apply(4);
        System.out.println(c2);

        // 方法推论 supplier
        Supplier<String> supplier = String::new;
        String s = supplier.get();
        System.out.println(s);

        // 自定义一个能够接收三个参数的方法
        ThreeFunction<String ,Long , String ,ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple apply = threeFunction.apply("Green", 123L, "fushi");
        System.out.println(apply);
    }

    private static <T> void testConsumer(Consumer<T> consumer ,T t){
        consumer.accept(t);
        consumer.accept(t);
    }
}
