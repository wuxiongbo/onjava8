// polymorphism/StaticPolymorphism.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Static methods are not polymorphic

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    /**
     * 静态方法不会被重写
     * @return
     */
    public static String staticGet() {
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

/**
 * 如果一个方法是静态的，那它的行为就不会是多态的
 * 静态方法 与 类 相关联，而不是 与 单个对象 相关联。
 *
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(StaticSuper.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
/* Output:
Base staticGet()
Derived dynamicGet()
*/
