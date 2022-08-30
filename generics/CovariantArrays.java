// generics/CovariantArrays.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


class Fruit {
}

// Jonathan（乔纳森）-> Apple -> Fruit
class Apple extends Fruit {
}
class Jonathan extends Apple {
}

// Orange -> Fruit
class Orange extends Fruit {
}


/**
 * 通配符 —————— ？
 *
 * 我们的起始示例要展示数组的一种特殊行为：
 *    你可以将 派生类数组 赋值给 基类数组的引用
 *
 *
 * 数组的这种赋值并不是那么可怕，因为在 ‘运行时’ 你可以发现插入了错误的类型。
 * 但是泛型的主要目标之一是，将这种错误检测移到 ‘编译期’。
 *
 * 所以，当我们试图使用泛型集合代替数组时，会发生什么呢？
 *
 * 下接 generics/NonCovariantGenerics.java
 *
 */
public class CovariantArrays {

    public static void main(String[] args) {
        // 虽然，可以将 派生类的数组 赋值给 基类的引用。 但是，向上转型 用在这里并不合适
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK

        // 运行时，类型  是 Apple[], 不是 Fruit[] 或 Orange[]:
        try {
            // 编译器允许你在编译期添加 Fruit。 但是，运行时 会报异常
            fruit[0] = new Fruit();  // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // 编译器允许你在编译期添加 Oranges。 但是，运行时 会报异常
            fruit[0] = new Orange();  // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }


        // 数组的这种赋值并不是那么可怕，因为在 运行时 你可以发现插入了错误的类型。
        // 但是，泛型的主要目标之一是，将这种错误检测移到 “编译期” 。
    }

}
/* Output:
java.lang.ArrayStoreException: Fruit
java.lang.ArrayStoreException: Orange
*/
