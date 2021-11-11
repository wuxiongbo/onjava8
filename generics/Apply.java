// generics/Apply.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;
import java.util.*;

/**
 * 上接 generics/LatentReflection.java
 *
 * 潜在类型机制
 *
 * 上个示例中，通过 反射 实现的 ‘潜在类型机制’  将所有的 ‘编译期类型检查’ 都转移到了 ‘运行时’ ，因此在许多情况下并不是我们所希望的。
 * 如果，能够同时实现  ‘编译期类型检查’ ，这通常会更符合要求。
 * 那么，有没可能  既实现 “潜在类型机制” 又具备 “编译期类型检查” 呢？
 *
 * <p>
 * 让我们看一个 能说明这个问题的示例：
 *    假设有个需求，想要创建一个 apply() 方法，该方法 能够将 ‘任何方法’ 应用于 ‘某个序列’（集合） 中的所有对象。
 *    这种情况下，使用接口并不适合，因为你想要将 ‘任何方法’ 应用于一个 ‘对象集合’ ，而 ‘接口’ 不可能描述 ‘任何方法’ 。
 *
 * 如何用 Java 来实现这个需求呢？
 * 最初，我们可以用 反射 来解决这个问题，由于有了 Java 的可变参数，这种方式被证明是相当优雅的。
 *
 *
 * 为了测试 Apply ，
 *      首先，我们创建一个 Shape 类：
 *          generics/Shape.java
 *      然后，创建一个 Square 子类：
 *          generics/Square.java
 * 现在，我们开始测试 Apply :
 *      见， generics/ApplyTest.java
 *
 */
public class Apply {

    /**
     *
     * @param seq    集合（即上述的 ‘某个序列’ ）
     * @param f      待执行的目标方法
     * @param args   方法参数列表。             引入 可变参数，使反射的调用更加灵活。
     * @param <T>
     * @param <S>    使用泛型对 方法参数的类型 进行约束。  S 至少是个 Iterable 类型。
     */
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object... args) {

        try {

            for (T t : seq) // 将 S 约束为 Iterable 类型，因此可将其遍历。
                f.invoke(t, args);

        } catch (IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {

            // Failures are programmer errors
            throw new RuntimeException(e);

        }

    }

}
