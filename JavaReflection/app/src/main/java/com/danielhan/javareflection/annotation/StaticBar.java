package com.danielhan.javareflection.annotation;

public class StaticBar implements Wine {
    private Wine wine;

    public StaticBar(Wine wine) {
        this.wine = wine;
    }

    @Override
    public void sayName() {
        System.out.println("before");
        wine.sayName();
        System.out.println("after");
    }
}
