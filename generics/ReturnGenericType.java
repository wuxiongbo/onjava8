// generics/ReturnGenericType.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 *  泛型只有在   “类型参数” 比 “某个具体类型”（以及其子类）  更加 “泛化” ————即，代码能跨多个类工作时，  才有用。
 *
 *  如：本示例。ReturnGenericType 类 有一个返回 T 的方法，那么泛型就有所帮助，因为它们之后将返回确切的类型
 * @param <T>
 */
class ReturnGenericType<T extends HasF> {
    private T obj;

    ReturnGenericType(T x) {
        obj = x;
    }

    public T get() {
        return obj;
    }
}
