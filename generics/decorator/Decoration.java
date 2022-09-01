// generics/decorator/Decoration.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java generics.decorator.Decoration}
package decorator;

// 被装饰者 或 被装饰者抽象
class Basic {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

// 装饰者抽象
class Decorator extends Basic {
    protected Basic basic; // 委托

    Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void set(String val) {
        basic.set(val);
    }

    @Override
    public String get() {
        return basic.get();
    }
}
// 装饰者实现1
class TimeStamped extends Decorator {
    private final long timeStamp;

    TimeStamped(Basic basic) {
        super(basic);
        timeStamp = System.currentTimeMillis();
    }

    public long getStamp() {
        return timeStamp;
    }
}
// 装饰者实现2
class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

/**
 * generics/Mixins.java  改写成使用 装饰器模式
 * <p>
 * 产生自泛型(Basic)的类(t2、s2)包含所有感兴趣的方法( 如：getStamp、getSerialNumber、set、get )，
 * 但是，由使用装饰器所产生的对象类型是最后被装饰的类型(TimeStamped 或 SerialNumbered)。
 * <p>
 * 也就是说，尽管可以添加多个层，但是最后一层才是实际的类型，因此只有最后一层的方法是可视的，而混型的类型是所有被混合到一起的类型。
 *
 * 换句话说，虽然，t2最终包含了所有的方法，但是只有最后一层的方法是可视的，所以还有一部分方法，虽然包含了，但是没办法显示的调用
 *
 * 因此，对于装饰器来说，其明显的缺陷是  “它只能有效地工作于装饰中的一层”（最后一层），而 混型方法 显然会更自然一些。
 * 因此，装饰器只是对由混型提出的问题的一种 “局限的解决方案” 。
 *
 * 使用 动态代理 来创建一种比 装饰器 更贴近 混型模型 的机制
 *  generics/DynamicProxyMixin.java
 */
public class Decoration {

    public static void main(String[] args) {

        TimeStamped t = new TimeStamped(new Basic());

        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        t2.get();
        t2.getStamp();
//        t2.getSerialNumber(); // 虽然包装了一层 SerialNumbered，但无法获取到 SerialNumbered.getSerialNumber() 函数




        SerialNumbered s = new SerialNumbered(new Basic());

        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        s2.get();
        s2.getSerialNumber();
//        s2.getStamp();       // 虽然包装了一层 TimeStamped，但无法获取到 TimeStamped.getStamp() 函数

    }
}
