// generics/SuperTypeWildcards.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 逆变。即，超类型通配符
 * <p>
 * 可以声明 通配符 是由 ‘某个特定类’的‘任何基类’ 来 “界定” 的，
 *
 * 方法 指定为 <？super MyClass> 或者 <？super T>
 * （你不能对 “泛型参数” 给出一个 “超类型边界”。 即，不能声明 <T super MyClass> ）
 *
 * <p>
 * 这使得，你可以安全地传递一个类型对象到泛型类型中。
 * 也就是说，有了超类型通配符，你就可以向 Collection 写入了。
 *
 * 由于 Apple 是下界，所以，向这样的 List 中添加 Fruit 是不安全的，
 * 因为 这将使这个 List 敞开口子，从而可以向其中添加 非Apple父类型 的对象，而这是违反静态类型安全（约束为Apple父类型）的。
 *
 */
public class SuperTypeWildcards {

    //  ? super Apple;   Apple的某个超类
    static void writeTo(List<? super Apple> apples) {

        // 可以写入了。
        apples.add(new Apple());
        apples.add(new Jonathan());

        // 由于不能确定具体是哪个超类，所以拒绝添加 任意Apple的超类，甚至是Object
//        apples.add(new Fruit()); // Error
//        apples.add(new Object()); // Error

    }

}
