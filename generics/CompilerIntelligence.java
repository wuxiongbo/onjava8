// generics/CompilerIntelligence.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());

        Apple a = (Apple) flist.get(0); // No warning


        // 编译器仅仅会拒绝调用像 add() 这样参数列表中涉及通配符的方法。

        // contains() 和 indexOf() 的参数类型是 Object，不涉及通配符，所以编译器允许调用它们。
        // 这意味着将由 泛型类的设计者 来决定哪些调用是 “安全的”，并使用 Object 类作为它们的参数类型。
        flist.contains(new Apple()); // Argument is 'Object'
        flist.indexOf(new Apple()); // Argument is 'Object'
    }

}
