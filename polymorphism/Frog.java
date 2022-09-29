// polymorphism/Frog.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cleanup and inheritance
// {java polymorphism.Frog}

// 特征
class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}

// 描述
class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }

    protected void dispose() {
        System.out.println("disposing Description " + s);
    }
}





// 生物
class LivingCreature {
    // 组合
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature");

    LivingCreature() {
        System.out.println("LivingCreature()");
    }

    protected void dispose() {
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

// 动物 继承自 生物
class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("has heart");
    private Description t = new Description("Animal not Vegetable");

    Animal() {
        System.out.println("Animal()");
    }

    @Override
    protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        // 在子类中重写dispose()时，记住调用基类版本的dispose() 很重要，否则，基类的清理就不会发生
        super.dispose();
    }
}

// 两栖动物 继承自 动物
class Amphibian extends Animal {
    private Characteristic p = new Characteristic("can live in water");
    private Description t = new Description("Both water and land");

    Amphibian() {
        System.out.println("Amphibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("Amphibian dispose");
        t.dispose();
        p.dispose();
        // 在子类中重写dispose()时，记住调用基类版本的dispose() 很重要，否则，基类的清理就不会发生
        super.dispose();
    }
}


/**
 * Frog对象 拥有它的成员对象： Characteristic 实例 以及  Description 实例。
 * Frog对象 创建的 它们，并且知道只要自己还存活着，这些成员对象就也要能正常工作，
 * 所以，Frog对象 知道什么时候对其成员对象进行dispose()。
 * 但是，如果其中某个成员对象 被 其他对象 所共享，则问题会变得更加复杂，此时，就不能简单地调用 dispose()。
 *
 * @see ReferenceCounting
 */
// 青蛙 继承自 两栖动物
public class Frog extends Amphibian {
    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats Bugs");

    public Frog() {
        System.out.println("Frog()");
    }

    @Override
    protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose();
        p.dispose();
        // 在子类中重写dispose()时，记住调用基类版本的dispose() 很重要，否则，基类的清理就不会发生
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }
}
/* Output:
Creating Characteristic is alive
Creating Description Basic Living Creature
LivingCreature()
Creating Characteristic has heart
Creating Description Animal not Vegetable
Animal()
Creating Characteristic can live in water
Creating Description Both water and land
Amphibian()
Creating Characteristic Croaks
Creating Description Eats Bugs
Frog()
Bye!
Frog dispose
disposing Description Eats Bugs
disposing Characteristic Croaks
Amphibian dispose
disposing Description Both water and land
disposing Characteristic can live in water
Animal dispose
disposing Description Animal not Vegetable
disposing Characteristic has heart
LivingCreature dispose
disposing Description Basic Living Creature
disposing Characteristic is alive
*/
