// generics/LatentReflection.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using reflection for latent typing

import java.lang.reflect.*;

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

// 利用 反射，调用 speak 与 sit 方法。 作为对缺乏潜在类型机制的补偿。 但是它将所有的 “类型检查” 都转移到了 “运行时”
class CommunicateReflectively {
    public static void perform(Object speaker) {

        Class<?> spkr = speaker.getClass();

        try {

            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }

            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }

        } catch (SecurityException |
                IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

/**
 *
 * 上接  generics/SimpleDogsAndRobots.java
 *
 * 潜在类型机制
 * java 没有 ‘潜在类型机制’ ，不过我们可以通过额外的努力，对这种缺陷进行 “补偿” （注意，仅仅是 补偿，而不是 实现 实现需要得到语言层面的支持）
 *
 * 使用 ‘反射技术’ ，对 缺乏 ‘潜在类型机制’ 进行 “补偿”
 *
 * 本例中，这些类完全是彼此分离的，没有任何公共基类（除了 Object ）或接口。
 * 本例通过 反射 实现 对于 缺乏“潜在类型机制”（鸭子类型机制） 的 “补偿”
 *
 * 虽然，反射提供了一些有用的可能性，但是，它将所有的 ‘类型检查’ 都转移到了“运行时”，而在许多情况下，这并不是我们所希望的。
 * 如果，能够实现 “编译期类型检查”，这通常会更符合要求。
 *
 *
 * 个人总结： 反射解决了 代码不够泛化的问题，但是，带来了新的问题，即，将 “编译期类型检查” 转移到了 “运行时”
 *
 * 再来一个反射示例：
 * generics/Apply.java
 *
 */
public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
Mime cannot speak
Pretending to sit
*/
