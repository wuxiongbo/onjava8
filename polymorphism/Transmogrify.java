// polymorphism/Transmogrify.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Dynamically changing the behavior of an object
// 通过组合动态的改变对象的行为（状态设计模式）

class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

/**
 * Stage对象包含了一个Actor的引用，它被初始化为一个HappyActor对象。
 * 这意味着，performPlay()方法 会产生特定的行为。
 * 因为，引用 可以在 "运行时" 重新绑定到不同的对象，
 * 所以，可以将actor中的引用 替换为 对SadActor对象的引用，这样，performPlay()产生的行为也随之改变。
 *
 * 因此，你就在  "运行时"  获得了动态灵活性（这也称为状态模式）。
 * 相反，你不能在 "运行时" 决定以不同的方式来继承，继承 必须在 编译期间 就完全确定下来。
 */
class Stage {

    // Stage 使用组合，来允许其状态发生改变。 而不用通过编码显式的继承来实现
    private Actor actor = new HappyActor();

    // 改变 Stage的状态。
    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

/**
 * 组合 优于 继承
 *
 * 多态，意味着用继承进行设计。
 * 但这会给你的设计增加负担。
 * 事实上，如果，在使用现有类创建新类时，首先选择 继承，事情可能会变得不必要地复杂。
 * 更好的方法是先选择 "组合"，尤其是在不清楚到底使用哪种方法时。
 * 组合 不会强制我们的程序设计使用继承层次结构。
 * 组合，也更加灵活，因为，在使用组合时，可以动态选择类型（以及随之而来的行为），
 * 而继承，则要求在 编译时 就知道确切的类型。
 *
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();

        stage.change();
        stage.performPlay();
    }
}
/* Output:
HappyActor
SadActor
*/
