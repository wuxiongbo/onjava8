// generics/Apply.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;
import java.util.*;

/**
 * 接 LatentReflection.java
 *
 * 有可能实现 “编译期类型检查” 和 “潜在类型机制” 吗？
 * <p>
 * 让我们看一个说明这个问题的示例。
 * 假设，想要创建一个 apply() 方法，它能够将任何方法应用于 ‘某个序列’（集合） 中的所有对象。
 * 这种情况下，使用接口并不适合，因为你想要将任何方法应用于一个对象集合，而接口不可能描述任何方法。
 *
 * 如何用 Java 来实现这个需求呢？
 * 最初，我们可以用 反射 来解决这个问题，由于有了 Java 的可变参数，这种方式被证明是相当优雅的
 *
 * 为了测试 Apply ，
 * 我们首先创建一个 Shape 类：
 *   generics/Shape.java
 * 被一个子类 Square 继承：
 *   generics/Square.java
 * 通过这些，我们可以测试 Apply：
 *   generics/ApplyTest.java
 *
 */
public class Apply {

    /**
     *
     * @param seq    集合（即，上述的 ‘某个序列’ ）
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
