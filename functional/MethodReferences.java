// functional/MethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Callable {                          // [1]
    void call(String s);
}

class Describe {
    void show(String msg) {                   // [2]
        System.out.println(msg);
    }
}


/**
 *
 * 绑定引用的情况下，
 * 函数式方法（接口中的单一方法）的签名 与 方法引用 的签名 要求完全匹配
 *
 * [1] 我们从只包含一个方法的接口开始（还是那样，一会儿你就知道它的重要性了）。
 * [2] show()的签名（参数类型和返回类型）和 Callable中 call() 的签名一致。
 * [3] hello()的签名 也和 call() 一致。
 * [4] help()是静态内部类中的一个非静态方法。
 * [5] assist()是静态内部类中的一个静态方法。
 *
 *
 * [6] 我们将Describe对象的一个方法引用，赋值给了一个Callable，Callable中没有show()方法，只有一个call()方法。
 *     然而，Java似乎对这种看似奇怪的赋值并没有意见，因为，这个 方法引用的签名 和 Callable中的call()方法 一致。
 * [7] 现在可以通过调用call()来调用show()，因为Java将call()映射到了show()上。
 * [8] 这是一个静态方法引用。
 * [9] 这是[6]的另一个版本：对 某个活跃对象上的方法 的 方法引用，有时 叫作 “绑定方法引用”（bound method reference）。
 * [10] 最后，获得静态内部类中的静态方法的方法引用，看起来就像在[8]处的外部类版本。
 *
 * 未绑定方法引用 见：
 * @see UnboundMethodReference
 *
 */
public class MethodReferences {
    static void hello(String name) {          // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {                 // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {        // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;                   // [6]  绑定方法引用
        c.call("call()");                    // [7]

        c = MethodReferences::hello;            // [8]  普通类的 静态方法引用
        c.call("Bob");

        c = new Description("valuable")::help;  // [9]  绑定方法引用
        c.call("information");

        c = Helper::assist;                     // [10] 静态类的 静态方法引用
        c.call("Help!");

//        Callable1 c1 = d::show;
    }
}

interface Callable1 {
    void call(Describe s);
}

/* Output:
call()
Hello, Bob
valuable information
Help!
*/
