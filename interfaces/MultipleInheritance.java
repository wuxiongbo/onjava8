// interfaces/MultipleInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

interface One {
    default void first() {
        System.out.println("first");
    }
}

interface Two {
    default void second() {
        System.out.println("second");
    }
}

interface Three {
    default void third() {
        System.out.println("third");
    }
}

class MI implements One, Two, Three {
}

/**
 * 将接口与默认方法结合，意味着我们可以结合来自多个基类型的 行为。
 * 因为接口仍然不允许包含字段（接口里只有静态字段，并不适用于我们这里讨论的场景），所以，字段仍然只能来自单个基类或抽象类。也就是说，你不能拥有 状态 的多重继承。
 */
public class MultipleInheritance {
    public static void main(String[] args) {
        MI mi = new MI();
        mi.first();
        mi.second();
        mi.third();
    }
}
/* Output:
first
second
third
*/
