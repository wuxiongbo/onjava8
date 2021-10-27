// generics/ArrayOfGeneric.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接 generics/ArrayOfGenericReference.java
 *
 * 补偿 泛型擦除：创建 泛型类型数组
 *
 * 创建 泛型数组的唯一方法：
 *   创建一个 “已擦除泛型的新数组” ，然后将其 强转为 “泛型类型数组”
 *
 *
 * 更复杂的示例  见： generics/GenericArray.java
 *
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;

    static Generic<Integer>[] gia;


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {


        // 虽可以 ‘定义’  “泛型数组”类型的 引用gia ，
        // 但无法 ‘创建’  具有该确切类型（包括类型参数）的数组。
//        gia = new Generic<Integer>[SIZE];



        // 似乎可以 创建一个 Object 数组 并将其转换为所需的数组类型。
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];

            // 实际上，这确实可以编译，但是会产生 ClassCastException
            // 问题在于，数组 会‘跟踪’其 ‘实际类型’，而该‘实际类型’是 在创建数组时 建立的。
            // 因此，即使 数组在创建后 立即强转为 Generic<Integer>[]类型的 gia 引用，
            // 该类型信息也仅在 ‘编译时’ 存在（并且 如果不加 @SuppressWarnings 注解，会有强制转换警告）。

        } catch (ClassCastException e) {
            System.out.println(e.getMessage()); // 在运行时，它仍然是一个Object 数组，这将引发异常。
        }





        // 成功创建泛型类型的数组的唯一方法：创建一个 “已擦除泛型的新数组” ，并将其 强制转换为 泛型数组。
        // Runtime type is the raw (erased) type:
        gia = (Generic<Integer>[]) new Generic[SIZE];

        System.out.println(gia.getClass().getSimpleName());

        gia[0] = new Generic<>();
//        gia[1] = new Object(); // 编译错误
//        gia[2] = new Generic<Double>(); // 编译期 发现类型不匹配


    }
}
/* Output:
[Ljava.lang.Object; cannot be cast to [LGeneric;
Generic[]
*/
