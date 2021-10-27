// generics/SimpleDogsAndRobots.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Removing the generic; code still works

class CommunicateSimply {
    static void perform(Performs performer) {
        performer.speak();
        performer.sit();
    }
}


/**
 * 接 generics/DogsAndRobots.java
 *
 * 潜在类型机制
 *
 * 上个例中，泛型不是必需的，因为这些类已经被强制要求实现 Performs 接口。
 *
 * 反射技术，可以实现 对 缺乏 潜在类型机制 的 补偿。
 * generics/LatentReflection.java
 *
 */
public class SimpleDogsAndRobots {
    public static void main(String[] args) {
        CommunicateSimply.perform(new PerformingDog());
        CommunicateSimply.perform(new Robot());
    }
}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
