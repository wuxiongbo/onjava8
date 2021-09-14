// generics/DogsAndRobotMethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// "Assisted Latent Typing"

import pets.Dog;

import java.util.function.*;

class PerformingDogA extends Dog {

    public void speak() {
        System.out.println("Woof!");
    }

    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class RobotA {
    public void speak() {
        System.out.println("Click!");
    }

    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {
    }
}

/**
 * Java8 中的辅助潜在类型。 使代码编写更加灵活
 */
class CommunicateA {
    public static <P> void perform(P performer, Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

/**
 * 对比 DogsAndRobots
 *
 * 不需要再继承 公共接口，来调用公共方法。
 *
 */
public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        // 之所以称其为 “辅助”，是因为您必须 显式地为 perform() 提供要使用的方法引用。它不能只按名称调用方法。
        CommunicateA.perform(new PerformingDogA(), PerformingDogA::speak, PerformingDogA::sit);
        CommunicateA.perform(new RobotA(), RobotA::speak, RobotA::sit);
        CommunicateA.perform(new Mime(), Mime::walkAgainstTheWind, Mime::pushInvisibleWalls);
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
