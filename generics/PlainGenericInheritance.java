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
 * 如果 使用泛型 但 不使用自限定：
 *      将重载参数类型。
 *
 * 如果使用了自限定（上个示例），将只能获得方法的一个版本，它将接受 ‘确切的参数类型’ 。
 *
 */
public class PlainGenericInheritance {
    public static void main(String[] args) {
        // 实例化 基类、派生类、 非自限定类
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();


        // 在这里，更具体的类(Derived)、基类(Base) 都可作为 非自限定类的方法参数。  从而触发了 ‘继承机制’ 导致 ‘方法重载’
        // void set(Derived derived)
        // void set(Base base)
        dgs.set(derived);
        dgs.set(base); // Overloaded, not overridden!
        // 传入 ‘具体类’ 未重载，传入 ‘基类’ 反而 导致了重载。
        // 因为，使用 父类的方法 触发了 ‘继承机制’，所以产生了 ‘方法重载’
        // （ “方法入参” 不同于 “方法返回”，“方法返回” 有 “参数协变” 机制 ）


        // 自限定类型，则避免了这种情况。  见上个示例： SelfBoundingAndCovariantArguments.java

    }
}
/* Output:
DerivedGS.set(Derived)
GenericSetter.set(Base)
*/
