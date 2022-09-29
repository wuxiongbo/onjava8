// interfaces/Adventure.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Multiple interfaces

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly {
    @Override
    public void swim() {
    }

    @Override
    public void fly() {
    }
}

/**
 * 本示例揭示了使用接口的核心原因之一：向上转型为多个基类型（以及这样做所提供的灵活性）。
 * 但是，使用接口的第二个原因与使用抽象基类相同：防止客户程序员创建此类的对象，并明确这只是一个接口。
 *
 * 这就带来了一个问题：应该使用接口还是抽象类？
 * 如果可以在没有任何方法定义或成员变量的情况下创建基类，那么就使用接口而非抽象类。
 * 事实上，如果你认为某个类可以作为基类的话，也就可以考虑把它设计成接口（在10.11节中会重新讨论这个主题）。
 */
public class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h); // Treat it as an ActionCharacter
    }
}
