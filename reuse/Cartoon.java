// reuse/Cartoon.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructor calls during inheritance
// 继承时调用构造器

/**
 *
 * 现在涉及两个类：基类和派生类。
 *
 * 想象一下 派生类 产生的对象，这可能会令人困惑。
 *
 *
 * 从外部看，新类 与 基类具有相同的接口，或许还有一些额外的方法和字段。
 * 但是，继承不只是复制基类的接口这么简单。
 * 当创建 派生类对象 时，它里面包含了一个基类的子对象（subobject）。这个 子对象 与 直接通过基类创建的对象  是一样的。
 * 只是从外面看，基类的子对象 被包裹在了 派生类的对象 中。
 *
 *  reuse/Chess.java
 */
class Art {  // 基类

    Art() {
        System.out.println("Art constructor");
    }

}

class Drawing extends Art {  // 派生类
    Drawing() {
//        super(); // Java自动插入
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {  // 派生类

    public Cartoon() {
        // 正确初始化 基类的子对象 至关重要，我们只有一种方法可以保证这一点：
        //     在 派生类(子类)构造器 中调用 基类(父类)构造器 来执行 初始化，它具有 执行 基类初始化 所需的 全部信息和权限。
        // Java会自动在 派生类构造器 中插入对基类构造器的调用。
        // 构造过程 是从  基类 “向外” 进行的，因此， 基类 在 派生类构造器 可以访问它之前 就已经被初始化了。
//        super(); // Java自动插入

        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }

}
/* Output:
Art constructor
Drawing constructor
Cartoon constructor
*/
