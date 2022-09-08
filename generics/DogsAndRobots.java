// generics/DogsAndRobots.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Java中并无（直接的）潜在类型机制
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
class Communicate { // 去泛型 版本，见下个示例。
    // perform()方法不需要使用泛型来工作，它可以被简单地指定为接受一个Performs 对象
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

/**
 *  潜在类型机制
 *
 *  java不具备 潜在类型机制
 *  但可以通过接口 实现 直接潜在类型
 *
 *  这种方式不够泛化，我们只能调用 接口中定义的方法，而不可能是“任意方法”，
 *  而且，后期维护新增功能，只能新增继承的接口 或 在已继承的接口中新增方法定义。
 *
 *
 *
 *  这里，泛型不是必须的，因此，可改写成以下版本：
 *  generics/SimpleDogsAndRobots.java
 *
 * @see SimpleDogsAndRobots
 */
public class DogsAndRobots {
    public static void main(String[] args) {
        // 使用沟通类 给 狗 传达 表演指令
        Communicate.perform(new PerformingDog());
        // 使用沟通类 给 机器人 传达 表演指令
        Communicate.perform(new Robot());
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
