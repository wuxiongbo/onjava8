// housekeeping/ExplicitStatic.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Explicit static initialization with "static" clause

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

/**
 * 无论是通过标为 [1] 的行访问静态的 cup1 对象，
 * 还是把标为 [1] 的行去掉，让它去运行标为 [2] 的那行代码（去掉 [2] 的注释），Cups 的静态初始化动作都会执行。
 * 如果同时注释 [1] 和 [2] 处，那么 Cups 的静态初始化就不会进行。
 * 此外，把标为 [2] 处的注释都去掉还是只去掉一个，静态初始化只会执行一次。
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);  // [1]
    }
    // static Cups cups1 = new Cups();  // [2]
    // static Cups cups2 = new Cups();  // [2]
}
/* Output:
Inside main()
Cup(1)
Cup(2)
f(99)
*/
