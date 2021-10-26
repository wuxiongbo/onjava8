// onjava/Suppliers.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A utility to use with Suppliers

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// Suppliers 供应商
public class Suppliers {

    // Create a collection and fill it:
    /**
     * 创建一个新的 Collection 容器，并且填充它
     * @param factory  容器(集合)生成工厂
     * @param gen      元素生成工厂
     * @param n        元素个数
     * @param <T>      集合中的元素类型
     * @param <C>      集合类型
     * @return
     */
    public static <T, C extends Collection<T>> C create(Supplier<C> factory, Supplier<T> gen, int n) {
        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }


    /**
     * Fill an existing collection:
     * fill() 的第一个版本，将元素放入 Collection 的现有子类型中。
     * 请注意，还会返回传入的容器的确切类型，因此不会丢失类型信息。
     * @param coll   集合容器
     * @param gen    元素生成工厂
     * @param n      元素个数
     * @param <T>    集合中的元素类型
     * @param <C>    集合类型
     * @return
     */
    public static <T, C extends Collection<T>> C fill(C coll,
                                                      Supplier<T> gen,
                                                      int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);
        return coll;
    }


    // 前两种方法一般都受约束，只能与 Collection 子类型一起使用。


    // Use an unbound method reference to produce a more general method:
    // fill() 的第二个版本，适用于任何类型的 holder 。
    //
    // 它需要一个附加参数：
    //      未绑定方法引用 adder.fill()，使用 “辅助潜在类型” 来使 其(adder) 与 任何具有添加元素方法的 holder 类型 一起使用。
    // 因为，此未绑定方法 adder， 必须带有一个参数（要添加到 holder 的元素），
    // 所以，adder 必须是 BiConsumer <H，A> ，
    // 其中， H 是要绑定到的 holder 对象的类型（λ表达式中的 holder），而 A 是要被添加的绑定元素类型（λ表达式中的 a）。
    public static <H, A> H fill(H holder, BiConsumer<H, A> adder,
                                Supplier<A> gen, int n) {

        Stream.generate(gen)
                .limit(n)
                .forEach(a -> adder.accept(holder, a));

        return holder;
    }

}
