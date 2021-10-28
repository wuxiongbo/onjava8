// innerclasses/MultiNestingAccess.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Nested classes can access all members of all
// levels of the classes they are nested within

/**
 * 内部类
 *
 * 一个 内部类 被嵌套多少层并不重要，因为，它能透明地访问所有它所嵌入的外部类的所有成员（即使它们被定义为 private）
 */
class MNA {
    private void f() {
    }

    class A {
        private void g() {
        }

        // 最内层的嵌套类，可以访问 所有它所嵌入的外部类 的 所有成员（即使被定义为 private）
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
