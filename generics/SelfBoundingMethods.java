// generics/SelfBoundingMethods.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接 generics/NotSelfBounded.java
 *
 * 将自限定用于泛型方法:
 *      这可以防止这个方法被应用于 除 上述形式的自限定参数(如，A类)  之外的任何事物上。
 *
 */
public class SelfBoundingMethods {

    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {

        // 自限定参数 可正常使用 f()方法
        A a = f(new A());

        // 非自限定参数 无法使用 f()方法
//        f(new B());
//        f(new D());

    }
}
