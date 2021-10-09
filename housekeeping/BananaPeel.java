// housekeeping/BananaPeel.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Banana {
    void peel(int i) { /* ... */ }
}

/**
 * 如果只有一个方法 peel() ，那么怎么知道调用的是对象 a 的 peel() 方法还是对象 b 的 peel() 方法呢？
 * 编译器做了一些底层工作，所以你可以像这样编写代码。
 * peel()方法中第一个参数隐密地传入了一个指向操作对象的引用。因此，上述例子中的方法调用像下面这样：
 * Banana.peel(a, 1)
 * Banana.peel(b, 2)
 * 这是在内部实现的，你不可以直接这么编写代码，编译器不会接受，但能说明到底发生了什么。
 *
 * 假设现在在方法内部，你想获得对当前对象的引用。但是，对象引用是被秘密地传达给编译器——并不在参数列表中。
 * 方便的是，有一个关键字: this 。
 * this 关键字只能在非静态方法内部使用。当你调用一个对象的方法时，this 生成了一个对象引用。
 *
 *
 * 通常当你说 this，意味着 “这个对象” 或 “当前对象”，它本身生成对当前对象的引用。
 * 在一个构造器中，当你给 this 一个参数列表时，它是另一层意思。它通过最直接的方式显式地调用匹配参数列表的构造器
 *
 *
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}
