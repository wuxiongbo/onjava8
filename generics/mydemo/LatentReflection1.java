package mydemo;
// generics/mydemo/LatentReflection1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using reflection for latent typing

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
class Mime {  // 没有实现 Performs 接口
    public void sit() {
        System.out.println("Pretending to sit");
    }

    public void walkAgainstTheWind() {
    }
    public void pushInvisibleWalls() {
    }

    @Override
    public String toString() {
        return "Mime";
    }
}
class SmartDog { // 没有实现 Performs 接口
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
 * 既满足了 “编译期类型检查”  又实现了对 “潜在类型机制”（鸭子类型机制） 的 补偿
 */
public class LatentReflection1 {

    // 实现 对  任意类 的 任意方法 进行调用
    public static void main(String[] args) {
        perform(SmartDog::new,SmartDog::sit,SmartDog::speak);
        perform(Robot::new,Robot::sit,Robot::speak);
        perform(Mime::new,Mime::sit);
    }

    /**
     * 比较典型的泛化的代码
     * 实现 调用 任意类 的 任意方法
     * @param factory
     * @param f
     * @param <T>
     */
    public static <T> void perform(Supplier<T> factory,Consumer<T>... f){
        T t = factory.get();
        for (Consumer<T> consumer : f) {
            consumer.accept(t);
        }
    }

}
