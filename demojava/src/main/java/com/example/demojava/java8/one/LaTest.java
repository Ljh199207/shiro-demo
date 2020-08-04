package com.example.demojava.java8.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ljh
 * @date 2019-11-27 17:05
 */
public class LaTest {

    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }

        });
        names.forEach(e -> System.out.println(e));
    }


    public static void test2() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        names.forEach(e -> System.out.println(e));
    }

    public static void test3() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        names.forEach(e -> System.out.println(e));
    }

}
