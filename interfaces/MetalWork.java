/**
 * @author Xander Wu
 * @date 2022/9/28 16:41
 */
class Heat implements Operation {
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}

/**
 * [1]：常规类Heat。
 * [2]：匿名类。
 * [3]：方法引用。
 * [4]：Lambda表达式——需要最少的代码。
 *
 */
public class MetalWork {
    public static void main(String[] args) {
        // 必须在静态上下文中定义才能使用方法引用
        Operation twist = new Operation() {
            public void execute() {
                Operation.show("Twist");
            }
        };
        Operation.runOps(
                new Heat(),                     // [1]
                new Operation() {               // [2]
                    public void execute() {
                        Operation.show("Hammer");
                    }
                },
                twist::execute,                      // [3]
                () -> Operation.show("Anneal")  // [4]
        );
    }
}
/* 输出：
Heat
Hammer
Twist
Anneal
*/