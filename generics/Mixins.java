// generics/Mixins.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

/**
 * Mixin 类基本上是在使用委托，因此每个混入类型都要求在 Mixin 中有一个相应的域，而你必须在 Mixin 中编写所有必需的方法，将方法调用转发给恰当的对象。
 *
 * 这个示例使用了非常简单的类，但是当使用更复杂的混型时，代码数量会急速增加。
 */
class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

public class Mixins {

    public static void main(String[] args) {

        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");

        System.out.println(
                mixin1.get() + " " +
                mixin1.getStamp() + " " +
                mixin1.getSerialNumber());

        System.out.println(
                mixin2.get() + " " +
                mixin2.getStamp() + " " +
                mixin2.getSerialNumber());

    }
}
/* Output:
test string 1 1611503367257 1
test string 2 1611503367258 2
*/
