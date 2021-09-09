// generics/ListOfGenerics.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 我们无法创建泛型数组。通用解决方案是在试图创建泛型数组的时候使用 ArrayList
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
