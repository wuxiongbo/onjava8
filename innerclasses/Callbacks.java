// innerclasses/Callbacks.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using inner classes for callbacks
// 使用内部类支持回调
// {java innerclasses.Callbacks}


interface Incrementable {
    void increment();
}



/**
 *
 * 这个示例展示了，在外围类中实现接口  和  在内部类中实现接口 的进一步区别
 *
 *
 * Callee2 在 继承 MyIncrement类 的同时，还实现了 Incrementable接口。
 *
 * 可看到，
 * Callee2 继承自 MyIncrement类，Callee2 已经有了一个increment() 方法，
 * 虽然与 Incrementable 接口 的 increment() 方法 同名，但期望的功能 完全不同。
 *
 * 所以，在这种情况下：
 *      Callee2 已经继承了 MyIncrement类，不能为了 实现Incrementable接口 而覆盖 继承的increment() 方法。
 *
 * 继承的类 与 将要实现的接口  方法 '相冲突' 该怎么办？
 * 于是，在此场景下，只能使用  内部类 独立地实现 Incrementable接口
 *
 * 这里还有个好处，当创建了一个内部类时，并没有在外部类的接口中添加东西，也没有修改外部类的接口。
 *
 * 这里，创建内部类时有点要注意：
 *   在 Callee2 中除了 getCallbackReference() 成员方法 以外，
 *   其他 成员方法、属性 以及 内部类  都是 private 修饰的。
 *
 * 所以，要想  内部类Closure  与 ‘外部世界’ 建立 任何连接，接口 Incrementable 都是必不可少的的。
 * 同时，在这里你还可以看到，接口 是如何支持 接口 与 实现 完全分离的。
 *
 *
 * 内部类 不仅 与 out-Class（外部类） 的 ‘私有成员’ 进行了连接，还 通过 ‘接口’ 实现了与 ‘外部世界’ 的连接。
 * 相当于，内部类 为 ‘外部世界’ 提供了一个间接访问 out-Class‘私有成员’ 的通道。
 *
 *
 * 内部类的承上启下：
 * 外部类 -》 内部类 -》 外部世界
 *
 */
class Callee2 extends MyIncrement {  // 被调用者 Callee2
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    // 私有内部类 实现了 Incrementable 接口。 Closure 是一个 “闭包”
    // 这是个 用来提供指回Callee2的 "钩子"，而且是一个安全的 "钩子"。
    // 不管是谁获得这个 Incrementable引用，都只能调用increment()，没有其他能力（因此不像指针那样可能会失去控制）。
    private class Closure implements Incrementable { // 如果你的类必须以其他方式再次实现 increment()，此时，你只能使用内部类
        @Override
        public void increment() { // 这是个钩子方法（hook），用来提供  指回Callee2 的能力

            Callee2.this.increment(); // 指回了 Callee2 。需指定为外部类的increment方法，否则将无限递归

        }
    }
    // 什么是钩子方法？ 我的理解是：
    // 在调用目标方法的过程中，被 ‘额外的方法’ 所 “拦截” ， 并在 “拦截” 前后加入新的逻辑，这里，‘额外的方法’就是 钩子方法。
    // 如上例，目标方法 是 Callee2.increment()， 钩子方法（拦截方法） 是 Closure.increment()


    Incrementable getCallbackReference() {
        return new Closure();
    }

}
class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// Callee1 只实现 接口。  重点观察 Callee2
class Callee1 implements Incrementable {  // 被调用者 Callee1
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class Caller {  // 调用者

    private Incrementable callbackReference;

    // Caller 依赖注入 一个Incrementable接口的引用。（不过，可以在任意时刻捕获 “回调引用”callbackReference）
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    // Caller对象 可以在以后的任意时刻，使用 callbackReference“回调引用” 来 回调Callee 类
    void go() {

        // ...其他逻辑...

        callbackReference.increment();

        // ...其他逻辑...

    }

    // 回调的价值 在于它的灵活性——可以在 “运行时” 动态地决定 需要调用什么方法。（多态）
}


/**
 *
 * 什么是“闭包” ？
 * 闭包（closure）是一个可调用的对象，它保留了 来自它被创建时所在的作用域  的信息。
 *
 *
 * 闭包 与 内部类：
 * 通过闭包的定义，可以看出， 内部类 是 面向对象 的闭包，
 * 因为，它不仅包含 外围类对象（“它被创建时所在的作用域”）的每一条信息，而且它自动持有着对整个外围类对象的引用。
 * 它有权操作 外部对象中的所有成员，甚至是private成员。
 *
 *
 * 闭包 与 lambda：
 * 在 Java 8 之前，内部类是实现闭包的唯一方式。
 * 在 Java 8 中，我们可以使用 lambda表达式来实现闭包行为，并且语法更加优雅和简洁，
 * 你将会在 函数式编程 这一章节中 学习相关细节。
 * 尽管相对于内部类，你可能更喜欢使用 lambda 表达式实现闭包，但是你会看到 并且 需要理解 那些在 Java 8 之前通过内部类方式实现闭包的代码，
 * 因此，仍然有必要来理解“内部类”这种实现闭包的方式。
 *
 *
 * 闭包 与 指针：
 * 人们认为Java应该包含某种指针机制，一个最有说服力的论据就是支持  回调（callback）。
 * 通过回调，对象能够携带一些信息，这些信息允许它在稍后的某个时刻调用初始的对象。稍后将会看到这是一个非常有用的概念。
 * 如果回调是通过指针实现的，那么就只能寄希望于程序员不会误用该指针。
 * 正如你所看到的，Java 更小心仔细，所以没有在语言中包括指针。
 * 通过 “内部类” 提供 闭包  是 很好的解决方案，它比指针更灵活、也更安全。
 *
 *
 */
public class Callbacks {

    public static void main(String[] args) {
        // 创建 被调用者
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();

        MyIncrement.f(c2);  // 调用 Callee2 继承MyIncrement类的 increment() 方法。  打印结果：1

        // 创建 调用者
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go();  // 调用 Callee1 实现Incrementable接口的 increment() 方法。  打印结果：1
        caller1.go();  // 调用 Callee1 实现Incrementable接口的 increment() 方法。  打印结果：2

        caller2.go();  // 调用 Callee2 内部类实现Incrementable接口的 increment() 方法。  打印结果：2
        caller2.go();  // 调用 Callee2 内部类实现Incrementable接口的 increment() 方法。  打印结果：3

        // 回调的价值在于 它的灵活性。 即，———— 可以在 运行时 动态地决定需要调用什么方法。如 caller1 caller2 所示
    }

}
/* Output:
Other operation
1
1
2
Other operation
2
Other operation
3
*/
