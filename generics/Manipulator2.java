// generics/Manipulator2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 给定泛型类一个边界，以此告诉编译器只能接受遵循这个边界的类型
 * 编译器实际上会把类型参数替换为它的擦除，如本示例，
 *     T 擦除到了 HasF，就像在类的声明中用 HasF 替换了 T 一样。
 * @param <T>
 */
class Manipulator2<T extends HasF> {
    private T obj;

    Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
