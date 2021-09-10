// generics/CovariantReturnTypes.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

/**
 *  注意，这段代码 在Java 5以下 不能编译，Java 5 囊括了 协变返回类型。
 *
 * DerivedGetter 中的 get() 方法覆盖了 OrdinaryGetter 中的 get() ，并返回了一个从 OrdinaryGetter.get() 的返回类型(Base)中导出的类型(Derived)。
 * 尽管这是完全合乎逻辑的事情（
 *      即，导出类方法( DerivedGetter.get() )应该能够返回  比 它覆盖的基类方法( OrdinaryGetter.get() )返回  更具体的类型
 *  ）
 * 但是，这在早先的Java 版本(java5以前)中是不合法的。
 */
interface DerivedGetter extends OrdinaryGetter {
    // Overridden method return type can vary:
    // 重写方法 的 返回类型 可以改变。  可返回为 更具体的类型
    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
