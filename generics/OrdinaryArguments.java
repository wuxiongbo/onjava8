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

public class OrdinaryArguments {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();


        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);

        // Compiles--overloaded, not overridden!:
        // 编译-- 重载，而不是覆盖！ 参数类型 不能随着 子类型 发生改变。
        ds.set(base);
    }

}
/* Output:
DerivedSetter.set(Derived)
OrdinarySetter.set(Base)
*/
