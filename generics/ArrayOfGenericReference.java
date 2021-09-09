// generics/ArrayOfGenericReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Generic<T> {
}

/**
 * 有时，仍然会创建泛型类型的数组（例如，ArrayList 在内部使用数组）。
 * 可以通过使编译器满意的方式定义对数组的通用引用
 */
public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;
}
