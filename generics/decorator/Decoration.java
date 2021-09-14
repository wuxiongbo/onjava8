// generics/decorator/Decoration.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java generics.decorator.Decoration}
package decorator;

import java.util.*;

class Basic {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

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

class TimeStamped extends Decorator {
    private final long timeStamp;

    TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

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
 * generics/Mixins.java  改写成使用装饰器
 *
 * 产生自泛型(Basic)的类(t2、s2)包含所有感兴趣的方法，但是由使用装饰器所产生的对象类型是最后被装饰的类型(TimeStamped 或 SerialNumbered)。
 *
 * 也就是说，尽管可以添加多个层，但是最后一层才是实际的类型，因此只有最后一层的方法是可视的，而混型的类型是所有被混合到一起的类型。
 * 因此，对于装饰器来说，其明显的缺陷是它只能有效地工作于装饰中的一层（最后一层），而混型方法显然会更自然一些。
 * 因此，装饰器只是对由混型提出的问题的一种局限的解决方案。
 *
 */
public class Decoration {

    public static void main(String[] args) {

        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));

        t2.get();
        t2.getStamp();
//        t2.getSerialNumber(); // Not available


        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));

        s2.get();
        s2.getSerialNumber();
//        s2.getStamp(); // Not available

    }
}
