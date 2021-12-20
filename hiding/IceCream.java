// hiding/IceCream.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates "private" keyword
// 演示private关键字


/**
 * 示例显示了一个private大显身手的场景：
 *
 * 控制对象的创建方式，并防止特定的构造器（或所有构造器）被调用。
 * 在这个例子中，你不能通过它的构造器来创建一个Sundae对象；相反，你必须调用makeASundae()方法 来创建Sundae对象。
 *
 *
 *
 * 这里还有另一个效果：
 *
 * 无参构造器是唯一定义的构造器，并且它是private的，因此这就阻止了该类的 "继承"（稍后会介绍这个主题）。
 *
 */
class Sundae {

    // 私有权限。 被私有的成员，只能本类访问。
    private Sundae() {
    }

    // 包访问权限。 将类的构造逻辑放在静态方法中
    static Sundae makeASundae() {
        return new Sundae();
    }

}

/**
 * 编译单元 IceCream.java
 *
 * 中有两个类  Sundae.class   IceCream.class
 *
 * @author Administrator
 */
public class IceCream {

    public static void main(String[] args) {


//        Sundae x = new Sundae();

        // 一个编译单元（即一个文件）只能属于一个包，所以一个 编译单元 中的 所有类 都可以通过 "包访问权限" 来相互访问。
        Sundae x = Sundae.makeASundae();

    }

}
