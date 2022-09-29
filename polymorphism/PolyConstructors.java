// polymorphism/PolyConstructors.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Constructors and polymorphism
// don't produce what you might expect

/**
 * Glyph.draw()是为重写而设计的，这个重写发生在 子类 RoundGlyph 中
 * 但是，Glyph构造器 调用了这个方法，而这个调用，实际上是对 子类RoundGlyph.draw()的调用。
 *
 * 1）在发生任何其他事情之前，为对象分配的存储空间会先被初始化为 二进制零。
 * 2）如前面所述的那样，调用基类的构造器。
 *    此时，被重写的draw()方法会被调用（是的，这发生在 RoundGlyph 构造器被调用之前），由于第1步的缘故，此时，会发现radius值为零。
 * 3）按声明的顺序来初始化成员。
 * 4）子类构造器的主体代码被执行。
 *
 */
// 符号
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

// 圆形的符号
class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

/**
 * 构造器内部的多态方法
 *
 * 从概念上讲，构造器的工作是创建对象（这并非是一件寻常的工作）。
 * 在构造器中，整个对象可能还只是部分形成—————只能知道基类对象是已初始化的。
 * 如果构造器还只是处于构建对象的过程中，并且，该对象是构造器所属类的子类对象，则当前构造器在调用时，其子类对象还没有被全部初始化。
 * 然而，动态绑定的方法调用，可以“向外”进入继承层次结构中。它可以调用子类中的方法。
 * 如果在构造器中执行此操作，则可以调用尚未初始化的成员的方法————这肯定会导致灾难。
 *
 * 示例：
 *      基类 Glyph 在构造器中调用 子类RoundGlyph 重写的 draw()方法
 *      因为这个被重写的 draw()方法 是 在子类对象完全构造之前被调用的。这可能会带来一些难以发现的错误。
 *
 *
 * 说明：
 *   编译器没有任何错误提示（在这种情况下，C++会产生更合理的行为）。
 *   像这样的错误，很容易被忽略，并且需要很长时间才能发现。
 *
 * 建议：
 *   编写 构造器时，有一个很好的准则：“用尽可能少的操作使对象进入正常状态，如果可以避免的话，请不要调用此类中的任何其他方法。”
 *   只有基类中的final方法可以在构造器中安全调用（这也适用于private方法，它们默认就是final的）。
 *   这些方法不能被重写，因此不会产生这种令人惊讶的问题。
 *   你可能并不总是遵循此准则，但是应该朝这个方向努力。
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
/* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*/
