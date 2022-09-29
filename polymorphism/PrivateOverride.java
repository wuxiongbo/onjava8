// polymorphism/PrivateOverride.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Trying to override a private method
// {java polymorphism.PrivateOverride}

public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {

    /**
     * 试图重写一个private方法。
     * private方法自动就是final的，所以，Derived的f()在这里是一个全新的方法。它甚至没有重载。
     * 它不会产生编译器警告，所以，有种重写private方法的 ”假象“
     * 建议：
     * 1）为了清楚起见，请在子类中使用与基类private方法不同的名称。
     * 2）如果使用了@Override注解，那么这个问题就会被检测出来
     */
    public void f() {
        System.out.println("public f()");
    }
}
/* Output:
private f()
*/
