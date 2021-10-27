// generics/ArrayOfGenericReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接 generics/ListOfGenerics.java
 *
 * 补偿 泛型擦除：创建 泛型类型数组
 *
 *
 * 有时，仍需要 创建 ‘泛型类型数组’（例如，ArrayList 在内部使用数组）。
 * 可以用 使‘编译器’满意的方式 定义 对数组的“通用引用”
 *
 *
 * 说明：看起来，‘编译器’ 能接受此操作 而不产生警告。
 *      但是，实际上我们永远无法创建具有该确切类型（包括类型参数）的数组（没有这样的语法，下个示例可以看到），这有点令人困惑。
 *
 *      我们沿着其他思路思考解决方案：
 *          既然，所有数组（无论它们持有什么类型）都具有相同的结构（每个数组 插槽的大小 和 数组布局 ），
 *          那么，我们似乎可以 先创建一个 ‘Object 数组’ ，然后立即转换为 所需的数组类型。
 *      实际上，这种方案确实可以通过 编译，但是 “运行时” 会产生 ClassCastException 异常
 *
 * 见： generics/ArrayOfGeneric.java
 */
public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;
}

class Generic<T> {
}