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
 * 自限定
 *  演示 参数协变
 *
 *
 * 注意，这段代码 在Java 5以下 不能编译，Java 5 囊括了 协变返回类型。
 *
 * DerivedGetter 中的 get() 方法 覆盖了父类 OrdinaryGetter 中的 get() ，
 * 并返回了 OrdinaryGetter.get() 的返回类型(Base) 导出的类型(Derived)。
 *
 * OrdinaryGetter.get()   Base        基类
 * DerivedGetter.get()    Derived     派生类
 *
 *
 * 导出类的方法( DerivedGetter.get() )  能够返回  比 被覆盖的基类方法( OrdinaryGetter.get() )返回  更具体的类型。
 * 尽管，这是完全合乎逻辑的事情
 *
 * 但是，这在早先的Java 版本(java5以前)中 是不合法的。
 *
 *
 * generics/GenericsAndReturnTypes.java
 *
 */
interface DerivedGetter extends OrdinaryGetter {
    // Overridden method return type can vary:
    // “重写方法”  的 ‘返回类型’ 可以改变。  可返回为 ‘更具体的类型’， 而不用 “方法重载”。  这就是 “参数协变”
    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {

        // 参数协变，使 “方法” 可以 返回具体类型 而不会 重载。
        Derived d2 = d.get();

    }
}
