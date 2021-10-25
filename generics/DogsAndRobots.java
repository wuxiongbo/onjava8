// generics/DogsAndRobots.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// No (direct) latent typing in Java

import pets.Dog;

// 表演的狗
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Click!");
    }

    @Override
    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {
    }
}

// Communicate 沟通、传达
// perform()方法不需要使用泛型来工作，它可以被简单地指定为接受一个Performs 对象
// 去掉泛型的写法见：  generics/SimpleDogsAndRobots.java
class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

// 潜在类型机制
public class DogsAndRobots {
    public static void main(String[] args) {
        // 给 狗 传达 表演指令
        Communicate.perform(new PerformingDog());
        // 给 机器人 传达 表演指令
        Communicate.perform(new Robot());
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
