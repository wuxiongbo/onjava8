// generics/ListOfGenerics.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 *
 * 补偿 泛型擦除：创建 泛型类型数组
 *
 * 我们无法创建泛型类型数组。通用解决方案是，在创建 ‘泛型类型数组’ 的时候 使用 ArrayList
 *
 * 优点：
 * 这样做可以获得数组的行为，并且还具有泛型提供的编译时类型安全性。
 *
 * 存在的问题：
 * 有时，仍然需要 创建 ‘泛型类型数组’ （例如，ArrayList 在内部使用数组）。
 *
 * 下接 generics/ArrayOfGenericReference.java
 *
 * @param <T>
 */
public class ListOfGenerics<T> {

    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }

}
