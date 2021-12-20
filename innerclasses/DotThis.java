// innerclasses/DotThis.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Accessing the outer-class object

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {

        public DotThis outer() {
            // 通过一个特殊的 this 引用 可以链接到 其 外部类对象。
            return DotThis.this;
            // 如果直接写“this”，引用的会是Inner的“this”
        }

        // 内部类不能包含静态关键字
//        public static void f() {}  // error

    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
/* Output:
DotThis.f()
*/
