// hiding/Cake.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// 在一个不同的编译单元访问类

/**
 *
 * 同一目录中所有其他文件，都有具有包访问权限，所以，Cake 可以使用 Pie 以及 Pie中被包访问权限修饰的成员。
 *
 * hiding/Pie.java
 */
class Cake {
    public static void main(String[] args) {
        Pie x = new Pie();
        x.f();
    }
}
/* Output:
Pie.f()
*/
