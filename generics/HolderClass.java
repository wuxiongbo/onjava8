// generics/Holder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Objects;

/**
 * 验证 编译器有多聪明?
 * <p>
 * Holder 有
 * 一个接受 T 类型对象   的 set() 方法，
 * 一个返回 T 类型对象   的 get() 方法
 * 一个接受 Object 对象 的 equals() 方法。
 * <p>
 * 逆变。
 * 下接 generics/SuperTypeWildcards.java
 *
 * @param <T>
 */
public class HolderClass<T> {

    private T value;

    private Class<?> clazz;

    public HolderClass() {
    }

    public HolderClass(T val) {
        clazz = val.getClass();
        value = val;
    }

    public void set(T val) {

        if (clazz.isInstance(val)) {
            value = val;
        } else {
            throw new UnsupportedOperationException();
        }

    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HolderClass
                &&
                Objects.equals(value, ((HolderClass) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }


    public static void main(String[] args) {

        Apple apple = new Apple();
        Fruit fruit = new Fruit();

        HolderClass appleHolder = new HolderClass(apple);


        appleHolder.set(apple);

        appleHolder.set(fruit);


    }
}
/* Output:
Exception in thread "main" java.lang.UnsupportedOperationException
*/
