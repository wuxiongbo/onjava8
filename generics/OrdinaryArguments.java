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
    // 方法重载。  将导致同个方法名存在多个版本
    // DerivedSetter 中存在两个版本set方法， “如果使用@Override，则会通过错误消息，显式的指出问题所在”
    //
    // 使用自限定类型的时候，子类中只有一个方法，而该方法 将派生类型 作为自身参数，而不是基类类型
//    @Override
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



        // 普通继承类 可设置 派生类
        // set 方法使用的派生类的版本
        ds.set(derived);
        // 普通继承类 也可设置  基类
        // set 方法使用的基类的版本
        ds.set(base);

        // 传递方法参数 将导致 “重载” 而不是 “覆盖”！  这是因为 参数类型 不具备协变能力 ，即， 参数类型 不能随着 子类型 发生改变


    }

}
/* Output:
DerivedSetter.set(Derived)
OrdinarySetter.set(Base)
*/
