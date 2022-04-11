// innerclasses/Parcel11.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Nested classes (static inner classes)

/**
 * 如果不需要内部类对象和外部类对象之间的连接，可以将内部类设置为static的。
 * 我们通常称之为——“嵌套类”。
 *
 * 要理解static 应用于内部类时的含义，请记住，普通内部类对象 中隐式地保留了一个 “引用”，指向创建该对象的外部类对象。
 *
 * 对于static的内部类来说，情况就不是这样了。嵌套类意味着：
 *    1.不需要一个 '外部类对象' 来创建 '嵌套类对象'；
 *    2.无法从 嵌套类对象 内部访问 非static的外部类对象。
 *
 * 从另一方面来看，嵌套类 和 普通内部类 还有些不同，即：
 *    由于 普通内部类 的字段和方法，只能放在类的外部层次中，
 *    所以，普通内部类中不能有static数据、static字段，也不能包含 嵌套类。
 *    但是 嵌套类 中可以包含所有这些内容
 */
public class Parcel11 {

    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static final class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }


        /**
         * Nested classes can contain other static elements:
         * 嵌套类 可以包含 其他 带有static关键字的 静态元素，
         * 普通内部类，则是不允许的
         *
         * 1)静态 方法
         */
        public static void f() {
        }
        // 2)静态 变量
        static int x = 10;
        // 3)静态 内部类
        static class AnotherLevel {
            public static void f() {
            }
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    /**
     * 在main()中，并不需要Parcel11对象；
     * 相反，我们使用选择static成员的普通语法 来调用方法，
     * 这些方法返回 指向Contents和Destination类型的引用。
     *
     * 普通内部类（非static的），可以使用特殊的this引用，来创建 指向外部类对象 的连接。
     * 而嵌套类 ，没有特殊的this引用，这使它和static方法类似。
     * @param args
     */
    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }

}
