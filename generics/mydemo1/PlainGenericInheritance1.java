package mydemo1;// generics/PlainGenericInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Base {
}
class Derived extends Base {
}


class GenericSetter<T extends GenericSetter<T>> {   // self-bounded
    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<DerivedGS> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}

/**
 * generics/PlainGenericInheritance.java
 *
 *
 * 使用自限定： 将只能获得方法的一个版本，这个版本的方法 只能接受 确切的参数类型。
 *
 */
public class PlainGenericInheritance1 {
    public static void main(String[] args) {

        Base base = new Base();
        Derived derived = new Derived();


        DerivedGS dgs = new DerivedGS();


        // 从编译期 就限制了只能使用 更具体的类(Derived) 可作为方法参数
//         void set(Derived derived)
//         void set(Base base)
        dgs.set(derived);

        // 传入基类(Base) 编译报错。在编译期就阻止了父类方法的调用，从而避免了 “方法重载”
//        dgs.set(base);

    }
}
/* Output:
DerivedGS.set(Derived)
*/
