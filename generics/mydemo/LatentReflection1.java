package mydemo;// generics/LatentReflection.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using reflection for latent typing

import interfacea.A;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Supplier;


class Robot {
    public void speak() {
        System.out.println("Click!");
    }

    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {
    }

}

// Does not implement Performs:
// 没有实现 Performs 接口
class Mime {
    public void walkAgainstTheWind() {
    }

    public void sit() {
        System.out.println("Pretending to sit");
    }

    public void pushInvisibleWalls() {
    }

    @Override
    public String toString() {
        return "Mime";
    }
}

// Does not implement Performs:
// 没有实现 Performs 接口
class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }

    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}


/**
 * 既满足了 “编译期类型检查”  又实现了 “潜在类型机制”（鸭子类型机制）
 *
 */
public class LatentReflection1 {

    public static void main(String[] args) {
        perform(SmartDog::new,SmartDog::sit,SmartDog::speak);
        perform(Robot::new,Robot::sit,Robot::speak);
        perform(Mime::new,Mime::sit);
    }


    public static <T> void perform(Supplier<T> factory,Consumer<T>... f){
        T t = factory.get();
        for (Consumer<T> consumer : f) {
            consumer.accept(t);
        }
    }

}
