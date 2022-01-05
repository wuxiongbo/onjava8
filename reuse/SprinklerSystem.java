// reuse/SprinklerSystem.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Composition for code reuse

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

/**
 * 假设你想要一个对象，它包含了  多个字符串对象、几个基本类型  以及 一个类对象。
 *
 */
public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    /**
     * 注解@Override用在toString()方法上，来让编译器确保我们实现了正确的重写。
     * - @Override是可选的，但它有助于验证有没有拼写错误（或更详细地说，有没有拼错大小写），或 有没有犯一些其他的常见错误。
     *
     * @return
     */
    @Override
    public String toString() {
        return "valve1 = " + valve1 + " " +
                "valve2 = " + valve2 + " " +
                "valve3 = " + valve3 + " " +
                "valve4 = " + valve4 + "\n" +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source;                      // [1]
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}
/* Output:
WaterSource()
valve1 = null valve2 = null valve3 = null valve4 = null
i = 0 f = 0.0 source = Constructed
*/
