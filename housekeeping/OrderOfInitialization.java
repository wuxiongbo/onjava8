// housekeeping/OrderOfInitialization.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates initialization order

// When the constructor is called to create a
// Window object, you'll see a message:
class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

/**
 * 在 House 类中，故意把几个 Window 对象的定义散布在各处，以证明它们全都会在调用构造器或其他方法之前得到初始化。
 * 此外，w3 在构造器中被再次赋值。
 *
 * 由输出可见，引用 w3 被初始化了两次：
 *   一次在调用构造器前，一次在构造器调用期间（第一次引用的对象将被丢弃，并作为垃圾回收）。
 */
class House {
    Window w1 = new Window(1); // Before constructor

    House() {
        // Show that we're in the constructor:
        System.out.println("House()");
        w3 = new Window(33); // Reinitialize w3
    }

    Window w2 = new Window(2); // After constructor

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3); // At end
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
}
/* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*/
