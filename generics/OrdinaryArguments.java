// generics/OrdinaryArguments.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class OrdinarySetter {
    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {
    // 方法重载。
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}

/**
 * 接 generics/GenericsAndReturnTypes.java
 *
 * 自限定
 *
 * 原始类型方法参数的 示例
 *
 * 演示：
 *   原始类型（非泛型），方法参数列表中的 ‘参数类型’ 不能随 ‘子类型’ 发生变化（即，参数协变）。 而是进行了‘方法重载’
 *
 *
 * generics/SelfBoundingAndCovariantArguments.java
 */
public class OrdinaryArguments {

    public static void main(String[] args) {
        // 实例化  基类、派生类、派生测试类
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();



        // 可设置 派生类
        ds.set(derived);
        // 可设置 基类
        ds.set(base);  // 传递方法参数 将导致 “重载” 而不是 “覆盖”！  这是因为 参数类型 不能随着 子类型 发生改变，即 参数类型 不具备协变能力


    }

}
/* Output:
DerivedSetter.set(Derived)
OrdinarySetter.set(Base)
*/
