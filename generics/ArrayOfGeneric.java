// generics/ArrayOfGeneric.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接 generics/ArrayOfGenericReference.java
 *
 * 创建泛型类型的数组
 *
 *
 * 更复杂的示例见： generics/GenericArray.java
 *
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;

    // 编译器 “接受” 此操作，且不产生警告
    static Generic<Integer>[] gia;   // 泛型类型的数组。


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // 虽可以定义泛型数组的引用，但我们无法 ‘创建’ 具有该确切类型（包括类型参数）的数组，因此有点令人困惑
//        gia = new Generic<Integer>[SIZE]; // Compile-time error

        try {
            // 由于所有数组，无论它们持有什么类型，都具有相同的结构（每个数组插槽的大小和数组布局），
            // 因此，似乎可以 创建一个 Object 数组 并将其转换为所需的数组类型。
            gia = (Generic<Integer>[]) new Object[SIZE];

            // 实际上，这确实可以编译，但是会产生 ClassCastException
            // 问题在于，数组会跟踪其实际类型，而该类型是在创建数组时建立的。
            // 因此，即使 gia 被强制转换为 Generic<Integer>[] ，该信息也仅在编译时存在（并且，若没有 @SuppressWarnings 注解，将会收到有关该强制转换的警告）。

        } catch (ClassCastException e) {

            // 在运行时，它仍然是一个Object 数组，这会引起问题。
            System.out.println(e.getMessage());
        }


        // 成功创建泛型类型的数组的唯一方法是，创建一个 “已擦除类型的新数组” ，并将其 强制转换。
        // Runtime type is the raw (erased) type:
        gia = (Generic<Integer>[]) new Generic[SIZE];


        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
//        gia[1] = new Object(); // 编译期 错误
//        gia[2] = new Generic<Double>(); // 编译期 发现类型不匹配

    }
}
/* Output:
[Ljava.lang.Object; cannot be cast to [LGeneric;
Generic[]
*/
