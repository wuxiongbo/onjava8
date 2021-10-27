// generics/GenericReading.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

// 复习 逆变 和 通配符 的使用
// 边界 读
// 协变——协助变化。
public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());


    // 泛型方法示例：
    // readExact() 方法使用了 精确的类型。
    // 如果使用这个没有任何通配符的 精确类型，则可以向 List 中 ‘写入’ 和 ‘读取’ 这个 精确类型。
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    // A static method adapts to each call:
    // 对于 静态泛型方法readExact()的返回值，可以有效地 “适应” 每个方法调用，能
    //  从 List<Apple> 中返回一个 Apple ，
    //  从 List<Fruit> 中返回一个 Fruit ，
    //  从 List<Apple> 中返回一个 Fruit
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }




    // 泛型类示例：
    // 对于 泛型类 来说，当你创建这个类的实例时，就要为这个类确定参数。
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }
    static void f2() {
        // 创建泛型类的实例时，为这个类确定泛型参数为 Fruit
        Reader<Fruit> fruitReader = new Reader<>();

        // 可以从 List<Fruit> 中读取一个 Fruit ，因为这就是它的确切类型。
        Fruit f = fruitReader.readExact(fruit);
        // 实际来讲，List<Apple> 也应该产生 Fruit 对象的，而 fruitReader 不允许这么做。
//        Fruit a = fruitReader.readExact(apples);

        // error: incompatible types: List<Apple>
        // cannot be converted to List<Fruit>

        // 下面，开始解决此问题。
    }

    // 为了修正这个问题，CovariantReader.readCovariant() 方法将接受 List<？extends T>
    // 因此，从这个列表中读取一个 T 是安全的（你所知道的，在这个列表中的所有对象至少是 T类型 ， 也可能是  继承自 T类型 的某种类型）。
    static class CovariantReader<T> {
        // 协变类型
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }
    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        // 现在，可以从 List<Apple> 中读取 Fruit 了。
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
