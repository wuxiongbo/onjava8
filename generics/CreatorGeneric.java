// generics/CreatorGeneric.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// create() 是模板方法，在子类中被重写以生成该类型的对象
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class XCreator extends GenericWithCreate<X> {

    // 子类中建立 T 的类型。
    @Override
    X create() {
        return new X();
    }

    void f() {
        // 在父类的构造方法中，调用了子类的create()方法，并为 element 赋值。 因此，这里可以直接获取到 element 实例。
        System.out.println(element.getClass().getSimpleName());
    }
}

/**
 * 接  generics/FactoryConstraint.java
 *
 * 补偿擦除 之 泛型类型的实例化方案三：
 * 模板方法设计模式
 *
 * GenericWithCreate 包含 element 字段，并通过 无参构造函数 强制其初始化，该构造函数又调用抽象的 create() 方法。
 * 这种创建方式可以在子类中定义，同时建立 T 的类型。
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}
/* Output:
X
*/
