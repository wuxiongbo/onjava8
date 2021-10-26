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
 * 接 generics/InstantiateGenericType.java
 *
 * 补偿擦除 之 泛型类型的实例化方案二：
 * 使用 显式工厂（Supplier）并 “约束类型”
 *
 *
 * 他们建议使用显式工厂（Supplier）并约束类型，以便只有实现该工厂的类可以这样创建对象。
 *
 * IntegerFactory 本身就是通过实现 Supplier<Integer> 的工厂。
 * Widget 包含一个内部类，它是一个工厂。
 * 还要注意，Fudge 并没有做任何类似于工厂的操作，但是传递 Fudge::new 仍然会产生工厂行为，
 *  这是因为，编译器将对函数方法 ::new 的调用转换为对get() 的调用。
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
