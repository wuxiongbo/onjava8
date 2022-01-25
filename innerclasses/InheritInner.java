// innerclasses/InheritInner.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheriting an inner class


// 外部类
class WithInner {
    // 内部类
    class Inner {
        protected int age =12;
    }
}

/**
 * 继承 内部类
 *
 * 因为，内部类的构造器  必须附着到  一个指向其包围类的对象的引用  上，
 * 所以，当你要继承内部类时，事情就稍微有点复杂了。
 * 问题在于，这个“秘密”的引用必须初始化，然而在 子类中 并没有  默认的对象 供其附着。
 * 你必须使用一种特殊的语法来明确地指出这种关联：
 *
 * 示例：
 * InheritInner只继承了内部类，而不是外围类。
 * 但是，当需要创建构造器时，默认构造器是行不通的，只传递一个指向其包围类对象的引用是不够的。
 *
 */
public class InheritInner extends WithInner.Inner {

    // 直接使用 默认构造器 无法通过编译
//    InheritInner() {}


    // 想继承 内部类，不仅需传递  外部类对象的“秘密”引用
    // 并且，还要使用 enclosingClassReference.super(); 语法，显式的调用 外部类的构造方法 。
    // 才能编译通过
    // enclosing  封闭；围合。   enclosing class  封闭类；外围类；外部类
    InheritInner(WithInner wi) {

        wi.super();

    }


    private void f(){
        System.out.println(age);
    }



    public static void main(String[] args) {

        WithInner wi = new WithInner();

        InheritInner ii = new InheritInner(wi);
        ii.f();
    }
}
