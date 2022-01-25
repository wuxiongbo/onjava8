// innerclasses/BigEgg.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// An inner class cannot be overridden like a method
// 内部类不能像方法一样被重写



// 给 Egg 定义一个内部类 Yolk
class Egg {

    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }


    private Yolk y;

    protected class Yolk {

        public Yolk() {
            System.out.println("Egg.Yolk()");
        }

    }


}

/**
 * 继承 外部类 并尝试覆盖其 内部类
 *
 * 例子：
 * 定义 BigEgg， 继承 外部类Egg 并尝试覆盖 Egg的内部类Yolk
 *
 * 结论：
 * 当继承了某个 外部类 的时候，内部类 并没有发生什么特别神奇的变化。
 *
 * 这两个内部类，是 “完全独立” 的两个实体，各自在自己的命名空间内。
 *
 */
public class BigEgg extends Egg {

    // 尝试重写 父类的内部类 Yolk ，发现 覆盖 并不起作用。
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }


    public static void main(String[] args) {
        new BigEgg();
    }

}
/* Output:
New Egg()
Egg.Yolk()
*/
