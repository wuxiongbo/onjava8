// innerclasses/AnonymousConstructor.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creating a constructor for an anonymous inner class

abstract class Base {
    Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}


/**
 * 匿名内部类‘构造器’传参 使用的 参数引用 不要求 final 修饰
 *
 *  innerclasses/Parcel10.java
 *
 */
public class AnonymousConstructor {

    public static Base getBase(int i) {  // 不需要 final 修饰

        return new Base(i) {

            // 为匿名内部类创建一个构造器
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
/* Output:
Base constructor, i = 47
Inside instance initializer
In anonymous f()
*/
