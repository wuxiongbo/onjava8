// innerclasses/BigEgg.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// An inner class cannot be overridden like a method


// 内部类
class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

/**
 * 继承 外部类 并尝试覆盖其 内部类
 *
 * 这个例子说明，当继承了某个外部类的时候，内部类并没有发生什么特别神奇的变化。
 * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
 */
public class BigEgg extends Egg {

    // 覆盖 并不起作用。
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
