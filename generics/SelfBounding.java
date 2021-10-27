// generics/SelfBounding.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 自限定。 采取额外的步骤，强制 泛型当作其自身的边界参数来使用。
 * @param <T>
 */
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

/**
 * 自限定的参数可以保证 ‘类型参数’ 必须与 ‘正在被定义的类’  相同。
 *
 * “自限定” 所做的，就是要求 “在继承关系中”  像下面A 类 这样 定义这个类:
 */
class A extends SelfBounded<A> {
}

// 尽管 在 A 类 中 看到的用法才是主要的用法
// 但 实际上，还可以像 B 类这样， 从  “使用了 另一个 自限定参数的SelfBounded”  中导出。（一般不会这么用，有违初衷）
class B extends SelfBounded<A> {
} // Also OK

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

// 普通类
class D {
}
// 类型参数使用普通类。编译报错。因为不能使用 非自限定类型 的参数
// class E extends SelfBounded<D> {}


// F 类 可以编译，不会有任何警告。所以，很遗憾，自限定 惯用法不是可强制执行的。
// 如果它确实很重要，也可以去 要求 外部工具， 来确保它不会使用 “原生类型” 来替代 “参数化类型”。
class F extends SelfBounded {
}

/**
 * 自限定 将采取额外的步骤，强制泛型当作其自身的边界参数来使用。
 * 观察所产生的类  可以如何使用 以及 不可以如何使用
 *
 * "自限定限制" 只能强制作用于 "继承关系" 。
 *
 * 移除自限定
 * 下接：generics/NotSelfBounded.java
 *
 */
public class SelfBounding {

    public static void main(String[] args) {
        A a = new A();
        C c = new C();


        // ‘参数’ 和 ‘返回值’，都被限制为 使用 导出类型(A)
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();


        // ‘参数’ 和 ‘返回值’，都被限制为 使用 导出类型(C)
        c = c.setAndGet(new C());

    }

}
