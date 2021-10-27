// generics/BasicHolder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接 generics/CuriouslyRecurringGeneric.java
 *
 * BasicHolder是一个 能够产生使用 导出类（T） 作为其 方法参数 和 返回类型 的 基类。
 * 它还能将导出类型用作其域类型
 *
 * 接 generics/CRGWithBasicHolder.java
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
