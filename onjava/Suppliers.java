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
    // 相对于第一版，它需要一个附加参数：
    //      即，未绑定方法 BiConsumer(adder)。
    //
    // 引用 fill()，需要使用 “辅助潜在类型” 来使，  BiConsumer(adder)   与  具有添加元素(标识A)功能的holder容器(标识H)  一起使用。
    //
    // 因为，此未绑定方法 BiConsumer(adder)， 必须带有一个参数（标识A。 holder中元素的类型），所以，adder 必须是 BiConsumer <H，A>
    // 其中， H 是，要绑定到的 holder 对象的类型（下面 λ表达式中的 holder），
    // 而    A 是，要被添加的绑定元素类型（下面 λ表达式中的 a）。
    public static <H, A> H fill(H holder,
                                BiConsumer<H, A> adder,
                                Supplier<A> gen,
                                int n) {

//        Stream.generate(gen)
//                .limit(n)
//                .forEach(a -> adder.accept(holder, a));



        // 下面是更好理解的写法。
        // Consumer匿名内部类。 用于对 BiConsumer 中的方法进行消费。
        Consumer<? super A> action = new Consumer<A>() {
            @Override
            public void accept(A a) {
                adder.accept(holder, a);
            }
        };

        // 生成 collect
        List<A> collect = Stream.generate(gen).limit(n).collect(Collectors.toList());
        // 遍历 collect，将元素逐个添加到 holder容器。
        collect.forEach(action);


        // 为什么 Consumer 要使用 逆变？
        // 先获取一个 A类型的 实例。
//        A a = gen.get();
        // 然后 用 逆变后的Consumer，接收 更具体的A类型。
//        action.accept(a);
        // 逆变，使得泛型类的方法 可写。
        // 点开forEach 里面 。表达的意思就是，Consumer 具体是什么类型的我不知道，但 Consumer 的方法一定可以接收 更具体的A类型。


        // 返回holder
        return holder;
    }

}
