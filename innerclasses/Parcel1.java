// innerclasses/Parcel1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creating inner classes

/**
 * 定义在 "另一个类" 中的 "类"，叫作 内部类。
 *
 * 内部类是一种非常有用的特性，因为它允许你把一些逻辑相关的类组织在一起，并控制位于内部的类的可见性。
 * 不过， 内部类 与 组合 是完全不同的概念，理解这一点很重要。
 *
 * 内部类乍一看像一种简单的代码隐藏机制：将代码放在其他类的内部。
 *
 *
 * 不过，你将会发现，内部类远不止如此，它 不仅了解外部类，还并能与之通信，而且你用内部类写出的代码更加优雅而清晰，尽管并非总是如此
 * （此外，Java 8 的 Lambda 表达式 和 方法引用 也减少了编写内部类的需求）
 *
 *
 * 刚接触内部类的时候，内部类可能看起来有些奇怪，而且要花些时间才能在设计中轻松地使用它们。
 * 也许很难直接判断是否需要使用内部类，但在介绍完内部类的基本语法与语义之后，11.8节 “Why inner classes?” 就开始使得 内部类 的益处 明确显现了。
 *
 *
 * 本章剩余部分包含了对内部类语法更加详尽的探索，这些特性是为了语言的完备性而设计的，但是你未必会用到，至少一开始不会。
 * 因此，本章最初的部分也许就是你现在所需的全部，至于更详细的讨论，则可以当作参考资料。
 *
 *
 * innerclasses/Parcel2.java
 *
 */
public class Parcel1 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    // Using inner classes looks just like
    // using any other class, within Parcel1:
    // 当我们在 ship() 方法里面使用内部类的时候，看上去与使用普通类没什么不同。
    // 表面上唯一的区别是，这些名字都是嵌套在Parcel1之中的。
    public void ship(String dest) {

        Contents c = new Contents();
        Destination d = new Destination(dest);

        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }

}
/* Output:
Tasmania
*/
