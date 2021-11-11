// innerclasses/mui/MultiInterfaces.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Two ways a class can implement multiple interfaces
// {java innerclasses.mui.MultiInterfaces}
package mui;


interface A {
}
interface B {
}

// 方式一： ‘外部类’ 实现两个接口
class X implements A, B {
}

// 方式二： ‘外部类’ 实现一个接口，‘内部类’ 实现另一个接口
class Y implements A {
    B makeB() {
        // 匿名内部类:
        return new B() {
        };
    }
}

/**
 * 为什么需要内部类？
 *
 * 内部类的两个重要特性：
 * 1）内部类 可以在 继承某个类 或 实现某个接口 的同时，访问或操作  外部类的 成员属性 及 成员方法。所以，可以认为内部类提供了某种进入其外部类的窗口。
 * 2）每个内部类 都能 独立地继承 自一个（接口的）实现，所以，无论外部类是否已经继承了某个（接口的）实现，对于 内部类 都没有影响。
 *
 * 特性的作用：
 * 拥有这两种特性，就可以认为具备“多重继承”的效力。也就是说，我们可以通过 “内部类” 实现 “多重继承” 了
 *
 * 也就是说，“内部类” 是，弥补  java没有“多重继承”语法特性 的一种解决方案。
 *
 *
 * 多重继承 解决方案的一种补充：
 * “内部类” 使得 “多重继承” 的解决方案变得完整。“接口” 解决了部分问题，而 “内部类” 有效地实现了 “多重继承”。
 * 即，“内部类” 的出现，允许 “外部类”  继承多个 ‘类’ 或 ‘抽象类’
 *
 *
 * 另一个例子：
 * 从实现的观点来看，当前的例子还看不出 使用内部类 有什么明显的区别，因为 方式一 方式二 它们都能正常运作。
 * 但是，如果换种场景，我们拥有的是 ‘抽象类’ 或 ‘具体类’ 而不是 ‘接口’，那么，这种情况 就只能使用 “内部类”的方式  才能实现 “多重继承” 了
 * innerclasses/MultiImplementation.java
 */
public class MultiInterfaces {

    static void takesA(A a) {
    }

    static void takesB(B b) {
    }

    public static void main(String[] args) {
        X x = new X();
        takesA(x);
        takesB(x);

        Y y = new Y();
        takesA(y);
        takesB(y.makeB()); // Y本身没有实现B接口，但可以通过内部类实现。

    }
}
