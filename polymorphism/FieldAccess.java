// polymorphism/FieldAccess.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Direct field access is determined at compile time

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

/**
 * 方法 调用 可以是多态的。在 运行时 确定
 * 字段，则该访问会在 编译时 解析。
 * <p>
 * <p>
 * Sub实际上包含两个被称为field的字段：
 * 它自己的字段 和
 * 它从Super继承的字段
 *
 * 建议：
 *   1）我们通常会将所有字段设为private，因此不会直接访问它们，而只会作为调用方法的副作用。
 *   2）我们一般不会为基类字段和子类字段指定相同的名称，因为这会造成混淆。
 */
public class FieldAccess {
    public static void main(String[] args) {
        // 多态： 方法调用的子类的。属性用的父类的。
        Super sup = new Sub(); // Upcast 向上转型
        System.out.println(
                "sup.field = " + sup.field +
                        ", sup.getField() = " + sup.getField());

        // Sub 包含两个 名为field的 字段
        Sub sub = new Sub();
        System.out.println(
                "sub.field = " + sub.field +
                        ", sub.getField() = " + sub.getField() +
                        ", sub.getSuperField() = " + sub.getSuperField());
    }
}
/* Output:
sup.field = 0, sup.getField() = 1
sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
*/
