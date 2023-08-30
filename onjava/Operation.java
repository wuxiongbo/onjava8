/**
 * @author Xander Wu
 * @date 2022/9/28 16:38
 */
public interface Operation {

    void execute();

    /**
     * Java 8 可以在接口中包含 静态方法。
     * 另外，这里，runOps() 使用可变参数列表，因为可传任意数量的方法参数。
     *
     * 此功能是一项改进，因为它允许将静态方法放在更合适的位置
     *
     * @param ops
     */
    static void runOps(Operation... ops) {
        for (Operation op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}
