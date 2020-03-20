package com.domi.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: java8-learning->FilterApple
 * @description:
 * @author: Domi·Song
 * @create: 2020-02-13 22:18
 **/
public class FilterApple {
    @FunctionalInterface
    public interface AppleFilter {
        boolean filter (Apple apple);
    }

    /**
     *
     * @Param [apples, appleFilter]
     * @return java.util.List<com.domi.java8.Apple>
     **/
    public static List<Apple> findApple (List<Apple> apples ,AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<Apple>();

        for (Apple apple:apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter {

        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }


    public static List<Apple> findGreenApple (List<Apple> apples){
        List<Apple> list = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple (List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
         List<Apple> list = Arrays.asList(new Apple("green",150),
                 new Apple("yellow",120), new Apple("green",170));

//         List<Apple> greenApples = findGreenApple(list);
//         assert greenApples.size() == 2 ;

//        List<Apple> yellowApples = findApple(list,"yellow");
//        System.out.println(yellowApples);

//        List<Apple> reslut = findApple(list, new GreenAnd150WeightFilter());
//        System.out.println(reslut);
//
//        List<Apple> yellowList = findApple(list, new AppleFilter() {
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//        System.out.println(yellowList);

//        List<Apple> lambdaResult = findApple(list , (Apple apple) -> {
//           return apple.getColor().equals("green");
//        });
//
//        System.out.println(lambdaResult);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
