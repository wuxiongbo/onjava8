// hiding/Lunch.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates class access specifiers. Make a class
// effectively private with private constructors:
// 演示类的访问权限修饰符，
// 通过私有的构造器让类的对象创建保持私有


/**
 * 当创建 包访问权限 的类时，将类的字段设为private仍然是有意义的
 *      ——你应该始终尽可能地将字段设为private
 *      ——但通常来说，给 '方法' 赋予和 '类' 相同的权限（包访问权限）是合理的。
 *      具有 包访问权限 的类，通常 仅在包内使用，
 *      因此，只有在受到强制要求的场景下，才应该将此类的方法设为public，至于什么时候处于这些场景中，编译器会提示你的。
 */
class Soup1 {

    private Soup1() {
    }

    public static Soup1 makeSoup() {          // [1]
        return new Soup1();
    }
}

class Soup2 {

    private Soup2() {
    }

    private static Soup2 ps1 = new Soup2();   // [2]

    public static Soup2 access() {
        return ps1;
    }

    public void f() {
    }
}

/**
 * 类不能是private（这将使除该类之外的任何类都无法访问它）或protected的。
 * 因此，对于类访问权限，只有两种选择：
 *      包访问权限 和 public
 *
 * 如果想要防止对该类的访问，可以将其所有的构造器都设为private，从而禁止其他人创建该类的对象，而你则可以在这个类的静态方法中创建对象。
 * (如：方式[1] 、 方式[2] 单例模式)
 *
 * 实际上， “内部类” 可以是 private 的 或 protected 的，但这是特殊情况。这些主题在第11章中会介绍。
 *
 */
// 每个文件只能有一个public类：
public class Lunch {
    void testPrivate() {
        // 不能这么做，构造器是私有的
//        Soup1 soup = new Soup1();
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }
}
