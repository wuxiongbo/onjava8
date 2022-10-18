// reflection/DynamicSupplier.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;
import java.util.stream.*;

class ID {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }

    // 如果想要调用getConstructor().newInstance()，
    // 就需要提供一个public的无参构造器：
    public ID() {
    }
}

// 泛型类语法 的使用示例。
// 它存储了一个类引用，然后使用newInstance()来生成对象
public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
/* Output:
10
11
12
13
14
*/
