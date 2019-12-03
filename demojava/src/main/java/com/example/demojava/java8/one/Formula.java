package com.example.demojava.java8.one;

/**
 * @author ljh
 * @date 2019-11-27 17:02
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
