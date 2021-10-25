// generics/NonCovariantGenerics.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}
import java.util.*;

/**
 * 示例：数组可以向上转型，List不能向上转型。这是为什么呢？
 *
 * 泛型不仅仅是关于集合，这段代码真正要表达的是 —— 不能把  "一个涉及 Apple 的泛型"  赋值给  "一个涉及 Fruit 的泛型"
 *
 * “Apple 的 List”  在类型上不等价于 “Fruit 的 List”，
 *      即使，Apple 是一种 Fruit 类型
 *
 * 真正的问题是，我们在讨论的 集合类型，而不是集合持有对象的类型。
 * 与数组不同，泛型没有内建的 “协变类型” 。
 * 这是因为数组是完全在语言中定义的，因此可以具有 “编译期” 和 “运行时” 的 内建检查，
 * 但是，在使用泛型时，“编译器” 和 “运行时系统” 不知道你想用类型做什么，以及应该采用什么规则。
 * 然而，有时，你想在两个类型间建立某种向上转型关系。“通配符” 可以产生这种关系。
 *
 * generics/GenericsAndCovariance.java
 *
 */
public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    // List<Fruit> flist = new ArrayList<Apple>();
}
