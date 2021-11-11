// innerclasses/MultiImplementation.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// For concrete or abstract classes, inner classes
// produce "multiple implementation inheritance"
// {java innerclasses.MultiImplementation}

class D {
}
abstract class E {
}


// Z类继承了D类，如果还想继承E，以实现 “多重继承” 的效果，那么，只能通过 内部类 的方式 来实现
class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

/**
 * 为什么需要内部类？
 *
 * 如果拥有的是 “抽象的类” 或 “具体的类” 而不是 “接口”，那就只能使用 内部类 才能实现 类似“多重继承” 的效果
 *
 *
 * 当然，如果不需要解决 “多重继承” 的问题，那么，自然可以用别的方式编写代码，而不需要使用 内部类。
 *
 *
 * 使用内部类，获得的其他特性：
 * 1. 内部类 可以有多个‘实例’ 。 每个‘实例’都有自己的‘状态信息’，并且与其‘外部类对象’的 ‘状态信息’相互独立。
 * 2. 在一个外部类中，可以让 “多个内部类”  以 不同的方式 “实现同一个接口 或 继承同一个类”，以避免造成实现上的覆盖。   见下个示例。
 * 3. 创建 内部类对象 的时刻 并不依赖于 外部类对象的创建
 * 4. ‘内部类’ 并没有令人迷惑的 “is-a” 关系，它就是一个独立的实体。
 *
 *  innerclasses/Callbacks.java
 */
public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();

        takesD(z);         // Z类本身 继承了D类
        takesE(z.makeE()); // Z类的内部类 实现了 E抽象类

        // Z同时具备了， D、E 的能力
    }
}
