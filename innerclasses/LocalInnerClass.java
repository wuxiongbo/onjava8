// innerclasses/LocalInnerClass.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Holds a sequence of Objects

interface Counter {
    int next();
}

/**
 *
 * Counter.class                          接口
 * LocalInnerClass$1.class                匿名内部类
 * LocalInnerClass$LocalCounter.class     普通内部类 或 局部内部类
 * LocalInnerClass.class                  类
 */
public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {
        // A local inner class:  局部内部类 不能有访问说明符，局部内部类的名字在方法外是不可见的
        class LocalCounter implements Counter {
            LocalCounter() {
                // 局部内部类 与 匿名内部类 的区别—— 可以有已命名的构造器。 因此可以产生 不止一个该内部类的实例对象
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // Repeat, but with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor, only an instance initializer:
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();

        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");

        for (int i = 0; i < 5; i++)
            System.out.println(c1.next());
        for (int i = 0; i < 5; i++)
            System.out.println(c2.next());

    }
}
/* Output:
LocalCounter()
Counter()
Local inner 0
Local inner 1
Local inner 2
Local inner 3
Local inner 4
Anonymous inner 5
Anonymous inner 6
Anonymous inner 7
Anonymous inner 8
Anonymous inner 9
*/
