// innerclasses/Callbacks.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using inner classes for callbacks
// {java innerclasses.Callbacks}


interface Incrementable {
    void increment();
}
// 只实现接口 非常简单
class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
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

/**
 * Callee2 继承自 MyIncrement，Callee2 已经有了一个increment() 方法，并且与 Incrementable 接口期望的 increment() 方法完全不相关。
 * 所以，如果 Callee2 继承了 MyIncrement，就不能为了 Incrementable 的用途 而覆盖 increment() 方法，
 * 于是，只能使用内部类独立地实现 Incrementable 。
 *
 * 这里还有个好处，当创建了一个内部类时，并没有在外部类的接口中添加东西，也没有修改外部类的接口。
 *
 * 这里，创建内部类时有点要注意：
 *   在 Callee2 中除了 getCallbackReference() 以外，其他成员都是 private的。
 *   所以，要想为 内部类Closure 建立与外部世界的任何连接，实现 接口 Incrementable 是必需的。
 *
 * 内部类，与 out-Class的 私有成员进行了连接，又通过 接口 实现了与外部世界的连接。
 *
 * 如果你的类必须以其他方式再次实现increment()，这种情况下 你只能使用内部类:
 */
class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    // 内部类 实现 Incrementable 接口
    private class Closure implements Incrementable {
        @Override
        public void increment() { // 这是个钩子方法（hook），而且是一个安全的钩子

            Callee2.this.increment();// 需指定为外部类的increment方法，否则将得到无限递归:

        }
    }
    // 什么是钩子方法？ 我的理解是：
    // 在调用目标方法的过程中，被 ‘额外的方法’ 所拦截 并在拦截前后加入新的逻辑，这里，‘额外的方法’就是 钩子方法。
    // 如上例，目标方法 是 Callee2.increment()， 钩子方法（拦截方法） 是 Closure.increment()


    Incrementable getCallbackReference() {
        return new Closure();
    }
}


class Caller {
    private Incrementable callbackReference;

    // Caller 的构造器需要一个 Incrementable 的引用  作为参数
    // （虽然，可以在任意时刻捕获  回调引用callbackReference ）
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    // Caller对象使用 此回调引用(callbackReference) 来回调  Callee 类
    void go() {
        callbackReference.increment();
    }
}


public class Callbacks {

    public static void main(String[] args) {
        // 创建 被调用者
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);  // 静态方法，调用 Callee2 本类的 increment() 方法  1

        // 创建 调用者
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go();  // 调用 Callee1 的 increment() 方法  1
        caller1.go();  // 调用 Callee1 的 increment() 方法  2

        caller2.go();  // 调用 Callee2 内部类的 increment() 方法  2
        caller2.go();  // 调用 Callee2 内部类的 increment() 方法  3

        // 回调的价值在于 它的灵活性——可以在 运行时 动态地决定需要调用什么方法。如 caller1 caller2 所示
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
