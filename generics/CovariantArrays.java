// generics/CovariantArrays.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

/**
 * 我们的起始示例要展示数组的一种特殊行为：
 *    你可以将 派生类的数组 赋值给 基类的引用
 */
public class CovariantArrays {

    public static void main(String[] args) {
        // 向上转型 用在这里不合适
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK

        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit();  // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange();  // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
/* Output:
java.lang.ArrayStoreException: Fruit
java.lang.ArrayStoreException: Orange
*/
