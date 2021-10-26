// generics/ArrayOfGenericReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Generic<T> {
}

/**
 * 接 generics/ListOfGenerics.java
 *
 * 有时，仍然会创建泛型类型的数组（例如，ArrayList 在内部使用数组）。
 *
 * 可以通过使编译器满意的方式定义 对数组的通用引用
 *
 *
 * 说明：编译器接受此操作而不产生警告。
 *      但是，我们永远无法创建具有该确切类型（包括类型参数）的数组，因此有点令人困惑。
 *      由于，所有数组，无论它们持有什么类型，都具有相同的结构（每个数组插槽的大小和数组布局），
 *      因此，似乎可以创建一个 ‘Object 数组’ 并将其转换为 所需的数组类型。
 *      实际上，这确实可以通过编译，但是 运行时 会产生 ClassCastException 异常
 *
 * 见： generics/ArrayOfGeneric.java
 */
public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;
}
