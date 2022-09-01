// generics/GenericCast.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

/**
 * 泛型存在的问题3：转型和警告
 * “转型” 或 “instanceof”  失效
 *
 * 由于 “泛型擦除” 导致了类型信息的丢失。因此，对带有 '泛型类型参数'的类型 ，使用 “转型” 或 “instanceof” 不会有任何效果
 * 例如，下面的集合，在内部将各个值存储为 Object，在获取这些值时，再将它们转型回 T
 *
 *
 * 不恰当的警告，见 generics/NeedCasting.java
 * @param <T>
 */
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
     * 由于擦除的原因，编译器无法知道这个转型是否安全。
     * 实际上 pop()方法也并没有执行任何转型。这是因为，T 被擦除到它的第一个边界，默认情况下这个边界是 Object，
     * 因此， pop() 实际上只是将 Object 转型为 Object。
     * @return
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        return index == 0 ? null : (T) storage[--index];  // 转型 失效，实际上是将 Object 转型为 Object
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

        // 测试 push方法
        Arrays.stream("ABCDEFGHIJKLMNOPQRS".split("")).forEach(strings::push);

        // 测试 pop 方法
        String s1 = strings.pop();
        System.out.println(s1);

        // 测试 stream 方法
        strings.stream()
                .map(s -> s + " ")
                .forEach(System.out::print);
    }
}
/* Output:
S
A B C D E F G H I J K L M N O P Q R S
*/
