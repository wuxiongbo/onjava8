// housekeeping/StaticInitialization.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Specifying initial values in a class definition

// 碗
class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

// 桌上的碗   bowl1(静态)  bowl2(静态)
class Table {
    static Bowl bowl1 = new Bowl(1);  // 静态成员变量   bowl1

    Table() {
        System.out.println("Table()");
        bowl2.f1(1);    // 使用静态成员变量  bowl2
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);  // 静态成员变量    bowl2
}

// 碗柜中的碗    bowl3  bowl4(静态)  bowl5(静态)
class Cupboard {
    Bowl bowl3 = new Bowl(3);         // 非静态成员变量  bowl3
    static Bowl bowl4 = new Bowl(4);  // 静态成员变量    bowl4

    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);    // 使用静态成员变量  bowl4
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);  // 静态成员变量    bowl5
}

/**
 * 只有在 第一个Cupboard 对象  被创建（或被访问） 时，静态变量才会被初始化。
 * 此后，静态对象不会再次被初始化。
 */
public class StaticInitialization {

    public static void main(String[] args) {

        System.out.println("main creating new Cupboard()");
        new Cupboard(); // 静态变量不再初始化

        System.out.println("main creating new Cupboard()");
        new Cupboard(); // 静态变量不再初始化


        table.f2(1);

        cupboard.f3(1);


        // 不需要实例化 Table 也可以 引用 Table.bowl1 或 Table.bowl2  静态成员变量
//        Bowl bowl1 = Table.bowl1;
//        Bowl bowl2 = Table.bowl2;
    }


    static Table table = new Table();

    // 静态初始化只有在必要时刻才会进行。
    // 如果，不创建 Table 对象，也不引用 Table.bowl1 或 Table.bowl2，
    // 那么，静态的 Bowl 类对象，bowl1 和 bowl2 永远不会被创建。
//    static Table table = null;

    static Cupboard cupboard = new Cupboard();

}
/* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)

Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)

main creating new Cupboard()
Bowl(3)
Cupboard()
f1(2)

main creating new Cupboard()
Bowl(3)
Cupboard()
f1(2)

f2(1)
f3(1)

*/
