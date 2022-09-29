// polymorphism/Reflect.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ThrowsException}

class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }
}

public class Reflect {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();

        // 编译时错误：无法在Useful中发现方法:
        // x[1].u();

        // 向下转型。
        ((MoreUseful) x[1]).u(); // 向下转型/反射
        ((MoreUseful) x[0]).u(); // 抛异常
    }
}
/* Output:
___[ Error Output ]___
Exception in thread "main" java.lang.ClassCastException: Useful cannot be cast to MoreUseful
    at Reflect.main(Reflect.java:46)
*/
