package com.demo.hutool.core;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

public class CloneTest {

    @Test
    public void test1() {
        Dog dog1 = new Dog("nike", 2);
        Dog dog2 = (Dog) dog1.clone();
        System.out.println(dog2);
    }

    @Test
    public void test2() {
        Cat cat1 = new Cat("tom", 2);
        Cat cat2 = cat1.clone();
        System.out.println(cat2);
    }

    // 深克隆
    @Test
    public void test3() {
        Dog dog1 = new Dog("nike", 2);
        Cat cat1 = new Cat("tom", 2);
        dog1.setCat(cat1);
        Dog clone = ObjectUtil.cloneByStream(dog1);
        cat1.setAge(15);
        System.out.println(dog1);
        System.out.println(clone);
    }

}

/**
 * 继承CloneSupport实现clone
 */
@Data
class Dog extends CloneSupport implements Serializable {

    private String name;

    private int age;

    private Cat cat;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/**
 * 实现Cloneable接口
 */
@Data
@AllArgsConstructor
class Cat implements Cloneable<Cat>, Serializable {

    private String name;

    private int age;

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
