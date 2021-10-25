package mydemo;// generics/PlainGenericInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Base {
}
class Derived extends Base {
}


class GenericSetter<T extends GenericSetter<T>> { // Not self-bounded
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
 * 使用自限定： 将只能获得方法的一个版本，它将接受 确切的参数类型。
 */
public class PlainGenericInheritance1 {
    public static void main(String[] args) {

        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();


        // 在这里， 更具体的类(Derived)、基类(Base) 都可作为方法参数。  从而 触发了继承机制 导致 方法重载
        // void set(Derived derived)
        // void set(Base base)
        dgs.set(derived);

        // 传入基类 编译报错。避免了方法重载
//        dgs.set(base);

    }
}
/* Output:
DerivedGS.set(Derived)
*/
