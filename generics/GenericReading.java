// generics/GenericReading.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

// 逆变 和 通配符 的使用
// 泛型 “读”
// 协变  协助变化。
public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    // 泛型方法。
    // readExact() 方法使用了 精确的类型。如果使用这个没有任何通配符的 精确类型，就可以向 List 中 ‘写入’ 和 ‘读取’ 这个 精确类型。
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    // A static method adapts to each call:
    // 另外，对于返回值，静态的泛型方法 readExact() 可以有效地 “适应” 每个方法调用，并能够
    //  从 List<Apple> 中返回一个 Apple ，
    //  从 List<Fruit> 中返回一个 Fruit ，
    //  从 List<Apple> 中返回一个 Fruit ， 就像在 f1() 中看到的那样。
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    // 泛型类。
    // 然而，对于 泛型类 来说，当你创建这个类的实例时，就要为这个类确定参数。
    // A class type is established
    // when the class is instantiated:
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    // 就像在 f2() 中看到的，
    static void f2() {
        // 创建这个泛型类的实例时，就要为这个类确定泛型参数
        Reader<Fruit> fruitReader = new Reader<>();

        // fruitReader 实例可以从 List<Fruit> 中读取一个 Fruit ，因为这就是它的确切类型。
        Fruit f = fruitReader.readExact(fruit);

        // 但是 List<Apple> 也应该产生 Fruit 对象，而 fruitReader 不允许这么做。
//        Fruit a = fruitReader.readExact(apples);

        // error: incompatible types: List<Apple>
        // cannot be converted to List<Fruit>

        // 下面，开始解决此问题。
    }

    // 为了修正这个问题，CovariantReader.readCovariant() 方法将接受 List<？extends T>
    // 因此，从这个列表中读取一个 T 是安全的（你知道，在这个列表中的所有对象至少是 T类型 ， 也可能是  继承自 T类型 的某种类型）。
    static class CovariantReader<T> {
        // 协变类型
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    // 在 f3() 中，你可以看到现在可以从 List<Apple> 中读取 Fruit 了。
    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
