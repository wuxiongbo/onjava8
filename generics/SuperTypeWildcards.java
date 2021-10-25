// generics/SuperTypeWildcards.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 逆变。即，超类型通配符
 *
 * 可以声明 通配符 是由 ‘某个特定类’的‘任何基类’ 来 “界定” 的，
 * 方法 指定为 <？super MyClass> 或者 使用类型参数<？super T>
 * （你不能对 “泛型参数” 给出一个 “超类型边界” ；即，不能声明 <T super MyClass> ）
 *
 * 这使得你可以安全地传递一个类型对象到泛型类型中。
 * 也就是说，有了超类型通配符，你就可以向 Collection 写入了。
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
}
