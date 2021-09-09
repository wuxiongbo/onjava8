// generics/FilledList.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.function.*;

public class FilledList<T> extends ArrayList<T> {

    // Supplier version:
    FilledList(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    /**
     * 如果在创建 List 的同时向其中放入一些对象,即使编译器无法得知 add() 中的 T 的任何信息，但它仍可以在编译期确保你放入FilledList 中的对象是 T 类型。
     *
     * 因此，即使 "擦除" 移除了方法或类中的实际类型的信息，编译器仍可以确保方法或类中使用的类型的内部一致性。
     * @param t
     * @param size
     */
    public FilledList(T t, int size) {
        super();
        for (int i = 0; i < size; i++)
            this.add(t);
    }


    public static void main(String[] args) {

        List<String> list = new FilledList<>("Hello", 4);
        System.out.println(list);

        // Supplier version:
        List<Integer> ilist = new FilledList<>(() -> 47, 4);
        System.out.println(ilist);

    }

}
/* Output:
[Hello, Hello, Hello, Hello]
[47, 47, 47, 47]
*/
