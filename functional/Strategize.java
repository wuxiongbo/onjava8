// functional/Strategize.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

/**
 * Strategy提供了接口，功能是通过其中唯一的approach()方法来承载的。
 * 通过创建不同的Strategy对象，我们可以创建不同的行为。
 * 传统上，我们通过定义一个实现了Strategy接口的类来完成这种行为，比如Soft。
 *
 * [1] 在Strategize中可以看到，Soft是默认的策略，因为它是在构造器中指定的。
 * [2] 更简洁、自然的方式是创建一个匿名内部类。这样仍然会存在一定数量的重复代码，而且我们总是要花点功夫才能明白这里是在使用匿名内部类。
 * [3] 这是Java 8的lambda表达式，突出的特点是用箭头 -> 将 参数 和 函数体 分隔开来。
 *     箭头右边是从lambda返回的表达式。这和 类定义 以及 匿名内部类 实现了同样的效果，但是代码要少得多。
 * [4] 这是Java 8的方法引用，突出的特点是:: 。
 *     ::的左边是 类名 或 对象名，右边是 方法名，但是没有参数列表。
 * [5] 在使用了默认的Soft策略之后，我们遍历数组中的所有策略，并使用changeStrategy()方法将每个策略放入s中。
 * [6] 现在，每次调用communicate()都会产生不同的行为，这取决于此时所使用的 策略“代码对象”。我们传递了‘行为’，而不只是传递’数据‘。（有时，函数式语言将其描述为“代码即数据”）
 */
public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft();                // [1]
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    // 传递了行为（代码对象），而不只是传递数据
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {                    // [2]
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5),         // [3]
                Unrelated::twice                    // [4]
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy);      // [5]
            s.communicate();                    // [6]
        }
    }
}
/* Output:
hello there?
HELLO THERE!
Hello
Hello there Hello there
*/
