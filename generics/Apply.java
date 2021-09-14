// generics/Apply.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;
import java.util.*;

/**
 * 有可能实现编译期类型检查和潜在类型机制吗？
 * <p>
 * 让我们看一个说明这个问题的示例。
 * 假设想要创建一个 apply() 方法，它能够将任何方法应用于某个序列中的所有对象。
 * 这种情况下使用接口不适合，因为你想要将任何方法应用于一个对象集合，而接口不可能描述任何方法。
 */
public class Apply {

    /**
     *
     * @param seq    集合（如上述的 某个序列）
     * @param f      待执行的方法
     * @param args   方法参数
     * @param <T>
     * @param <S>
     */
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {

        try {

            for (T t : seq)
                f.invoke(t, args);

        } catch (IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {

            // Failures are programmer errors
            throw new RuntimeException(e);

        }

    }

}
