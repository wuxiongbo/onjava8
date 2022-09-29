// polymorphism/CovariantReturn.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    /**
     * 重写方法 允许更具体的Wheat返回类型
     * @return
     */
    @Override
    Wheat process() {
        return new Wheat();
    }
}

/**
 * 方法返回值中的多态
 * Java 5 添加了 协变返回类型（covariant return type），这表示 子类中重写方法的返回值 可以是 基类方法返回值 的 子类型
 * <p>
 * Java 5 与 Java 5 之前版本 的主要区别在于：
 *   Java 5 之前版本，强制要求process()的重写版本 返回 基类Grain，而不能是 Wheat，即使，Wheat 继承自 Grain 。
 *   Java 5 中的协变返回类型，则允许更具体的 Wheat 返回类型。
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}
/* Output:
Grain
Wheat
*/
