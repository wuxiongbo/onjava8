// generics/FactoryConstraint.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.function.*;

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget {
    private int id;

    Widget(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    public static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}

/**
 *
 * InstantiateGenericType.java 由于错误不是在编译时捕获的，因此语言创建者不赞成这种方法。
 *
 * 他们建议使用显式工厂（Supplier）并约束类型，以便只有实现该工厂的类可以这样创建对象。
 *
 */
public class FactoryConstraint {

    public static void main(String[] args) {

        System.out.println(new Foo2<>(new IntegerFactory())); // Integer
        System.out.println(new Foo2<>(new Widget.Factory())); // Widget
        System.out.println(new Foo2<>(Fudge::new)); //Fudge

    }

}
/* Output:
[1, 2, 3, 4, 5]
[Widget 1, Widget 2, Widget 3, Widget 4, Widget 5]
[Fudge 1, Fudge 2, Fudge 3, Fudge 4, Fudge 5]
*/
