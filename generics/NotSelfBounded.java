// generics/NotSelfBounded.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 可以移除自限定这个限制，这样所有的类仍旧是可以编译的，但是 E 也会因此而变得可编译
 * @param <T>
 */
public class NotSelfBounded<T> {
    T element;

    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A2 extends NotSelfBounded<A2> {
}

class B2 extends NotSelfBounded<A2> {
}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}

class D2 {
}

// Now this is OK:
class E2 extends NotSelfBounded<D2> {
}
