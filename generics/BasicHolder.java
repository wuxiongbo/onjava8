// generics/BasicHolder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * BasicHolder是一个 能够产生使用导出类作为其参数和返回类型的  基类。
 * 它还能将导出类型用作其域类型
 *
 * @param <T>
 */
public class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
