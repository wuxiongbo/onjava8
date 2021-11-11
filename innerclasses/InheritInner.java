// innerclasses/InheritInner.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheriting an inner class


// 内部类
class WithInner {
    class Inner {
    }
}

// 继承内部类
public class InheritInner extends WithInner.Inner {

    // 直接使用 默认构造器 无法通过编译
//    InheritInner() {}


    // 想继承内部类，不仅需传递一个指向外部类对象的引用
    InheritInner(WithInner wi) {

        // 并且，还要使用 enclosingClassReference.super(); 语法 显式的调用外部类的构造方法。
        wi.super();

        // 这样，才能编译通过。
    }


    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
