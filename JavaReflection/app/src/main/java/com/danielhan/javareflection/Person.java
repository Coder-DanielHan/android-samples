package com.danielhan.javareflection;

/**
 * @author DanielHan
 * @date 2018/4/24
 */
public class Person implements China {
    public Person() {

    }

    public Person(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void sayChina() {
        System.out.println("hello ,china");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }

    private String sex;

    @Override
    public String toString() {
        return "[name:" + name + ",age:" + age + ",sex:" + sex + "]";
    }
}
