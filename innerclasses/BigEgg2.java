// innerclasses/BigEgg2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// 正确继承内部类

class Egg2 {

    protected class Yolk {

        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk(); // 第一次调用 Egg2.Yolk()

    Egg2() {
        System.out.println("New Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        // 用到的是，子类对 f()的重写版本
        y.f();
    }
}

public class BigEgg2 extends Egg2 {

    // 明确地继承 Egg2的内部类
    public class Yolk extends Egg2.Yolk {

        public Yolk() {

            super(); // 第二次调用 Egg2.Yolk()

            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        super();  // Egg2()
        // 多态。BigEgg2.Yolk对象  向上转型为  Egg2.Yolk对象
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();

        e2.g();

    }
}
/* Output:
Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()
*/
