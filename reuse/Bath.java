// reuse/Bath.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructor initialization with composition
// 使用组合进行构造器初始化

/**
 * 初始化引用有下列4种方式：
 *
 *   1.在定义对象时。
 *     这意味着,它们将始终在调用构造器之前被初始化。
 *
 *   2.在该类的构造器中。
 *
 *   3.在对象实际使用之前。
 *     这通常称为 ———— 延迟初始化（lazy initialization）。
 *     在对象创建成本高昂且不需要每次都创建的情况下，它可以减少开销。
 *
 *   4.使用实例初始化。
 *
 *
 * 以下是这4种方式的示例：
 *
 */
class Soap {
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {

    private String // 1. 在定义时初始化
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;
    private Soap castile;
    private int i;
    private float toy;


    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();  // 2. 在构造器中初始化
    }

    // 4. 实例初始化
    {
        i = 47;
    }

    @Override
    public String toString() {
        if (s4 == null) { // 3. 延迟初始化
            s4 = "Joy";
        }
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castile = " + castile;
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}
/* Output:
Inside Bath()
Soap()
s1 = Happy
s2 = Happy
s3 = Joy
s4 = Joy
i = 47
toy = 3.14
castile = Constructed
*/
