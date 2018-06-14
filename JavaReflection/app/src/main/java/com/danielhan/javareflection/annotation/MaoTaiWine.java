package com.danielhan.javareflection.annotation;

public class MaoTaiWine implements Wine {
    @Override
    public void sayName() {
        System.out.println("我是茅台酒");
    }
}
