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
 * 如果不使用自限定：  本示例
 *      将重载参数类型。
 *
 * 如果使用了自限定：  SelfBoundingAndCovariantArguments.java
 *      只能获得方法的一个版本，它将接受确切的参数类型。
 */
public class PlainGenericInheritance {
    public static void main(String[] args) {

        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();

        dgs.set(derived);
        // 重载，不是 覆盖
        dgs.set(base); // Overloaded, not overridden!

    }
}
/* Output:
DerivedGS.set(Derived)
GenericSetter.set(Base)
*/
