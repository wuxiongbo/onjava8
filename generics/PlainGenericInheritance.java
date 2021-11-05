// generics/PlainGenericInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class GenericSetter<T> { // Not self-bounded
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

/**
 * 上接： generics/SelfBoundingAndCovariantArguments.java
 *
 * 使用泛型 但 不使用自限定：
 *      将重载参数类型。
 *
 *
 * 对比
 * generics/mydemo/PlainGenericInheritance1.java
 *
 */
public class PlainGenericInheritance {
    public static void main(String[] args) {
        // 实例化 基类、派生类、 非自限定类
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();


        // 非自限定泛型类的 方法参数 使用 更具体的类(Derived)、基类(Base) 都可以 。 这是因为触发了 ‘继承机制’ 而导致了 ‘方法重载’
        dgs.set(derived);
        dgs.set(base); // Overloaded, not overridden!


        // 为什么传入 ‘具体类’ 未重载，传入 ‘基类’ 反而 导致了 重载 呢？
        // 因为， 传入‘基类’参数类型时  使用的是 父类的方法 。 使用父类方法 会 触发 ‘继承机制’，所以 产生了 ‘方法重载’
        // （再次强调 “方法参数” 不同于 “方法返回”，“方法返回” 有 “参数协变” 机制 ，“方法参数”  没有 “参数协变”）

        // 自限定类型，则避免了这种 方法重载 的情况。  见上个示例： SelfBoundingAndCovariantArguments.java

    }
}
/* Output:
DerivedGS.set(Derived)
GenericSetter.set(Base)
*/
