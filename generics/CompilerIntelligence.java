// generics/CompilerIntelligence.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 上接 generics/CovariantArrays.java
 *
 * 通过查看 ArrayList 的文档，我们发现编译器没有那么聪明。
 *
 * 正如 ArrayList 源码所示，
 *      尽管 add() 方法 接受的是一个 “泛型参数类型” 的参数，
 *      但  contains() 和 indexOf() 方法 接受的 是 “Object”类型 的参数 。
 *
 * 因此，当你指定一个 ArrayList<? extends Fruit> 时，add() 的 方法参数 就变成了 “? extends Fruit”。
 * 从这个 约束所描述的信息中，“编译器” 无法得知 这里需要 Fruit的哪个具体子类型，因此它不会接受任何类型的 Fruit。
 *
 * 验证 编译器有多聪明
 * generics/Holder.java
 *
 */
public class CompilerIntelligence {

    public static void main(String[] args) {
        // 先把 Apple 向上转型为 Fruit， 这也是可以正常编译的。 因为，编译器仅仅会拒绝调用 像 add() 这种 “参数列表” 中涉及 ‘通配符’ 的方法。
        List<? extends Fruit> flist = Arrays.asList(new Apple());

        Apple a = (Apple) flist.get(0); // No warning

        // contains() 和 indexOf() 的参数类型是 Object，不涉及通配符，所以编译器允许调用它们。
        flist.contains(new Apple()); // Argument is 'Object'
        flist.indexOf(new Apple()); // Argument is 'Object'

        // add() 方法的 “参数列表” 涉及 ‘通配符’。 编译报错。
//        flist.add(new Apple());


        // 同样是 List中的方法，add() 的参数列表 涉及通配符，而 contains() 和 indexOf() 的参数列表 不涉及通配符。
        // 这意味着，将由 泛型类的设计者 来决定哪些调用是 “安全的”，并使用 Object 类作为它们的参数类型。

    }

}
