// generics/GenericCast.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

// 使用带有泛型类型参数的转型或 instanceof 不会有任何效果
// 下面的集合在内部将各个值存储为 Object，并在获取这些值时，再将它们转型回 T
class FixedSizeStack<T> {
    private final int size;
    private Object[] storage;
    private int index = 0;

    FixedSizeStack(int size) {
        this.size = size;
        storage = new Object[size];
    }

    public void push(T item) {
        if (index < size)
            storage[index++] = item;
    }

    /**
     * 由于擦除的原因，pop() 方法实际上并没有执行任何转型。
     * 这是因为，T 被擦除到它的第一个边界，默认情况下是 Object，因此 pop() 实际上只是将 Object 转型为 Object。
     * @return
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        return index == 0 ? null : (T) storage[--index];
    }

    @SuppressWarnings("unchecked")
    Stream<T> stream() {
        return (Stream<T>) Arrays.stream(storage);
    }
}

public class GenericCast {

    static String[] letters = "ABCDEFGHIJKLMNOPQRS".split("");

    public static void main(String[] args) {

        FixedSizeStack<String> strings = new FixedSizeStack<>(letters.length);

        Arrays.stream("ABCDEFGHIJKLMNOPQRS".split("")).forEach(strings::push);

        String s1 = strings.pop();
        System.out.println(s1);

        strings.stream()
                .map(s -> s + " ")
                .forEach(System.out::print);
    }
}
/* Output:
S
A B C D E F G H I J K L M N O P Q R S
*/
