// generics/SelfBounding.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 自限定 将采取额外的步骤，强制 泛型当作其自身的边界参数来使用。
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
 * 自限定的参数有何意义呢？ 它可以保证 ‘类型参数’ 必须与 ‘正在被定义的类’  相同。
 *
 * “自限定” 所做的，就是要求在继承关系中，像下面这样使用这个类:
 */
class A extends SelfBounded<A> {
}

// 尽管 在 A 类 中看到的用法，才是主要的用法
// 但实际上，还可以像 B 类这样， 从  “使用了 另一个 自限定参数的SelfBounded”  中导出。（一般不会这么用，有违初衷）
class B extends SelfBounded<A> {
} // Also OK

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

// 编译报错。不能使用  非自限定 的类型参数
// class E extends SelfBounded<D> {}


// Alas, you can do this, so you cannot force the idiom:
// 遗憾的是，自限定惯用法不是可强制执行的。 如下：F 类 可以编译，不会有任何警告
// 但，如果它确实很重要，可以要求一个外部工具 来确保不会使用 “原生类型” 来替代 “参数化类型”。
class F extends SelfBounded {
}

/**
 *
 */
public class SelfBounding {

    public static void main(String[] args) {

        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();


        C c = new C();
        c = c.setAndGet(new C());

    }

}
