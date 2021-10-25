// housekeeping/PassingThis.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        // ... remove peel
        return apple; // Peeled
    }
}

/**
 * Apple 因为某些原因（比如说工具类中的方法在多个类中重复出现，你不想代码
 * 重复），必须调用一个外部工具方法 Peeler.peel() 做一些行为。必须使用 this 才能
 * 将自身传递给外部方法。
 */
class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
/* Output:
Yummy
*/
