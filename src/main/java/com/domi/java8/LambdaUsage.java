package com.domi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by Domi on 2020/03/05.
 */
public class LambdaUsage {

    private static List<Apple> filter (List<Apple> source , Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();

        for (Apple a : source){
            if (predicate.test(a))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source , LongPredicate longPredicate){
        List<Apple> result = new ArrayList<>();

        for (Apple a : source){
            if (longPredicate.test(a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByBiPredivate(List<Apple> source , BiPredicate<String,Long> biPredicate){
        List<Apple> result = new ArrayList<>();

        for (Apple a : source){
            if (biPredicate.test(a.getColor(),a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> simpleTestConsumer (List<Apple> list , Consumer<Apple> consumer){
        List<Apple> result = new ArrayList<>();

        for (Apple a:list){
            consumer.accept(a);
        }
        return result;
    }

    /**
     *
     * @Param [s, list, biConsumer]
     * @return java.util.List<com.domi.java8.Apple>
     **/
    private static List<Apple> simpleBiConsumer (String s ,List<Apple> list , BiConsumer<Apple,String> biConsumer){
        List<Apple> result = new ArrayList<>();

        for (Apple a:list){
            biConsumer.accept(a ,s);
        }
        return result;
    }

    private static String testFunction( Apple apple,Function<Apple,String> function){
        return function.apply(apple);
    }

    private static Apple testBiFunction(String color ,long weight ,BiFunction<String ,Long ,Apple> fun){
        return fun.apply(color ,weight);
    }

    public static void main(String[] args){
        /*Runnable r1 = () -> System.out.println("Hello");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        process(r1);
        process(r2);
        process(()-> System.out.println("Hello Man ~"));*/

        List<Apple> list = Arrays.asList(new Apple("green",120), new Apple("red",150));
        List<Apple> getGreenAppleList = filter(list , (Apple apple)->apple.getColor().equals("green"));
        System.out.println(getGreenAppleList);

        List<Apple> getWeightList = filterByWeight(list ,w -> w > 100);
        System.out.println(getWeightList);

        List<Apple> getList = filterByBiPredivate(list ,(s ,w) -> w > 100 && s.equals("green"));
        System.out.println(getList);

        System.out.println("-----------");
        simpleTestConsumer(list ,apple -> System.out.println(apple));

        System.out.println("===========");
        simpleBiConsumer("XXX",list,(a,s)-> System.out.println(s + a.getColor() + ",and Weight =" + a.getWeight()));

        String result = testFunction(new Apple("yellow",120) ,apple -> apple.getColor());
        System.out.println(result);

        IntFunction<Double> intFunction = i->i*100.0d;
        double resukt2 = intFunction.apply(10);
        System.out.println(resukt2);
        System.out.println("------------");

        Apple result3 =testBiFunction("bule",120 ,(s,w) -> new Apple(s ,w));
        System.out.println(result3);

        System.out.println("============");

        Supplier<String> supplier = String :: new; //method reference 方法推倒
        System.out.println(supplier.get().getClass());

        Apple result4 = createApple( () -> new Apple("black",90));
        System.out.println(result4);

        // final 类型E
    }

    private static void process(Runnable runnable){
        runnable.run();
    }


    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }
}
