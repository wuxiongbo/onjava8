// generics/GenericsAndCovariance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * generics/NonCovariantGenerics.java
 *
 * 通配符？
 *
 * 正如上例所看到的那样，有时，你想在两个类型间建立某种向上转型关系。
 * 这个时候，我们就可以使用 “通配符” 来产生这种关系
 *
 *
 * 然而，我们发现，加上通配符后，事情开始变得有点走极端了，因为现在，你甚至不能向 刚刚声明过将持有Apple 对象的 List 中放入一个 Apple 对象。
 * 是的，这并没有问题，因为，虽然 你可能知道  将添加的是Fruit的哪个具体子类型 ，但编译器并不知道这一点。
 * 因为，List<? extends Fruit> 可能合法地指向一个 List<Orange>。  显然，在这种情况下 Apple 是不符合条件的。
 * 同样，向这样的 List 中添加 Fruit 也是不安全的，假设，List<? extends Fruit> 成功添加了Fruit ，
 * 这将使这个 List 敞开口子，从而可以向其中添加 任何Fruit型非Apple型的对象(如，同样继承自Fruit的Orange)，而这是违反静态类型安全的。
 * 所以，编译器在不确定是 Fruit 的哪个具体子类型 的时候，拒绝传递任何对象。
 *
 *
 * 因此，一旦将 泛型类 执行这种类型的向上转型，你就丢失了向此泛型类中传递任何对象的能力，甚至传递 Object 也不行。(因为Object 并不是 Fruit的子类型)
 *
 *
 * 编译器有多聪明？
 * 下接  generics/CompilerIntelligence.java
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();

        // 当你指定一个 ArrayList<? extends Fruit> 时，add() 的参数就变成了 “? extends Fruit”。
        // 从这个描述中，编译器 无法得知这里需要 Fruit 的哪个具体子类型，因此它不会接受任何类型的 Fruit。
        // 编译错误: 不能添加任何类型的object
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());  // 甚至，传递 Object 也不行

        flist.add(null); // 合法，但无意义

        Fruit f = flist.get(0); //我们知道，它至少返回的是 Fruit类型

    }

}
