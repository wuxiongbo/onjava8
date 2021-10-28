// innerclasses/Parcel10.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using "instance initialization" to perform
// construction on an anonymous inner class

public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        // 匿名内部类 只能实现一个接口。除非继承一个多接口的实现。
        return new Destination() {
            private int cost;

            // 在匿名类中不可能有命名构造器（因为它根本没名字！），那如果想做一些类似构造器的行为，该怎么办呢？
            // 可以通过 “实例初始化” 达到为匿名内部类创建一个构造器的效果
            // 对于匿名类而言，“实例初始化” 的实际效果就是 构造器。当然，它受到了限制，即，你不能 重载 实例初始化方法，所以，你也仅有一个这样的构造器。
            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Over budget!");
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
/* Output:
Over budget!
*/
