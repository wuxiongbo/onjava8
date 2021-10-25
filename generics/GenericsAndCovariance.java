// generics/GenericsAndCovariance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 有时，你想在两个类型间建立某种向上转型关系。  通配符可以产生这种关系
 *
 * 但是，事情开始变得有点走极端了，因为现在，你甚至不能向 刚刚声明过将持有Apple 对象的 List 中放入一个 Apple 对象。
 * 是的，但编译器并不知道这一点。List<? extends Fruit> 可能合法地指向一个 List<Orange>。
 * 一旦执行这种类型的向上转型，你就丢失了向其中传递任何对象的能力，甚至传递 Object 也不行。
 *
 * 编译器有多聪明？
 * generics/CompilerIntelligence.java
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();

        // 当你指定一个 ArrayList<? extends Fruit> 时，add() 的参数就变成了 “? extends Fruit”。
        // 从这个描述中，编译器 无法得知这里需要 Fruit 的哪个具体子类型，因此它不会接受任何类型的 Fruit。
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());

        flist.add(null); // Legal but uninteresting
        // We know it returns at least Fruit:
        Fruit f = flist.get(0);

    }

}
