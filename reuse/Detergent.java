// reuse/Detergent.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheritance syntax & properties
// 继承的语法与属性

class Cleanser {  // 省略 ‘访问权限修饰符’，则该 类/类成员 的权限默认是 “包访问权限”

    private String s = "Cleanser";

    public void append(String a) {
        s += a;  // += 操作符，是Java设计者为处理 字符串对象 而重载的操作符之一。
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

/**
 * Cleanser在其接口中有一组方法：append()、dilute()、apply()、scrub()和toString()。
 *
 * 因为，Detergent继承了Cleanser（通过extends关键字），
 * 所以，它的接口就自动获得了这些方法，即使并没有在Detergent中显式定义它们。
 *
 * 因此，可以将 “继承” 视作 ‘对类的复用’。
 *
 */
public class Detergent extends Cleanser {
    // 修改方法：
    @Override
    public void scrub() {
        append(" Detergent.scrub()");

        super.scrub(); // 调用基类版本

        // 正如在scrub()中看到的那样，可以使用基类中定义的方法并对其进行修改。
        // 在这个示例中，你可能想从新版本的方法里调用继承来的基类方法。
        // 但是在scrub()中不能简单地调用scrub()，因为这会产生递归调用。
        // 为了解决这个问题，Java提供了super关键字，来指代当前类继承的“超类”（基类）。
        // 因此，表达式super.scrub()调用了基类版本的scrub()方法。
//        scrub();  // 这样会无限递归

    }

    // 向接口里添加新方法
    public void foam() {
        append(" foam()");
    }

    // 测试新类
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");

        Cleanser.main(args);
    }
}
/* Output:
Cleanser dilute() apply() Detergent.scrub() scrub()
foam()
Testing base class:
Cleanser dilute() apply() scrub()
*/
