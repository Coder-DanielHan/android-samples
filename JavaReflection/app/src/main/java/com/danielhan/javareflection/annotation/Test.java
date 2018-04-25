package com.danielhan.javareflection.annotation;

/**
 * @author DanielHan
 * @date 2018/4/25
 */
@TestAnnotation(id = 1, msg = "DanielHan")
public class Test {

    public static void main(String[] args) {
        if (Test.class.isAnnotationPresent(TestAnnotation.class)) {
            TestAnnotation annotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + annotation.id() + ",msg:" + annotation.msg());
        }
    }
}
