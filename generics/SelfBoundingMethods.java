// generics/SelfBoundingMethods.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class SelfBoundingMethods {
    /**
     * 将自限定用于泛型方法:
     *      这可以防止这个方法被应用于除  上述形式的自限定参数(如，A类)  之外的任何事物上。
     * @param arg
     * @param <T>
     * @return
     */
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());

//        f(new B());
//        f(new D());

    }
}
