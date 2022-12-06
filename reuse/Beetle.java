// reuse/Beetle.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The full process of initialization

class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}


/**
 * 初始化 及 类的加载
 *
 * 每个类的编译代码都存在于自己的单独文件中。只有在需要它的代码的时候才会加载该文件。
 * 一般可以认为， “类的代码在第一次使用时才加载”。
 * 这通常是在构造该类的第一个对象时，但在访问 静态字段 或 静态方法 时，也会触发文件的加载。
 * 尽管没有显式指定static关键字，但 构造器 也是一个静态方法。
 * 所以，准确地说，当一个class 的任何 静态成员 被访问时，都会触发 该class文件 的加载。
 *
 *
 * 一、类加载
 * 当你运行java Beetle时，
 * 1）首先，会尝试访问静态方法Beetle.main()，所以，加载器会去Beetle.class文件中找到Beetle类的编译代码。
 * 2）在加载它的代码时，加载器注意到有一个基类，然后，它就会去加载基类。无论是否创建该基类的对象，都会发生这种情况。（可以尝试注释掉对象创建来验证一下。）
 * 3）如果基类又有自己的基类，那么，第二个基类也将被加载，以此类推。
 * 4）接下来，会执行 根基类（本例中为Insect）中的 静态初始化，
 * 5）然后，是下一个子类，以此类推。这很重要，因为，子类的 静态初始化 可能依赖于 基类成员的正确初始化。
 *
 * 二、创建对象
 * 现在，所有必要的类都已加载，因此，可以创建对象了。
 * 1）首先，该对象中的所有基本类型都被设为其默认值，并且，对象引用被设为null————这通过 将对象中的内存设置为二进制零 来 一步实现。
 * 2）然后，调用 基类构造器。这里的调用是自动的，但也可以通过 super关键字 来指定基类构造器的调用（需要作为Beetle构造器中的第一个操作）。
 * 3）基类构造器 以与 子类构造器 相同的顺序  经历相同的过程。
 * 4）基类构造器完成后，子类的实例变量按文本顺序初始化。
 * 5）最后，执行子类构造器的其余部分。
 *
 */
public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
//        super();
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }

}
/* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*/
