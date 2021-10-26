// generics/GenericArray.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接  generics/ArrayOfGeneric.java
 *
 *  创建泛型类型的数组
 *
 * 创建一个 包装数组的 简单泛型包装器
 *
 * 存在的问题：
 * rep() 方法返回一个 T[] ，在主方法中它应该是 gai 的 Integer[]，
 * 但是如果调用它并尝试将结果转换为 Integer[] 引用，则会得到 ClassCastException，这再次是因为实际的运行时类型为 Object[] 。
 *
 * 问题原因：
 * 由于擦除，数组的运行时类型只能是 Object[] 。
 * 如果我们立即将其转换为 T[] ，则在编译时会丢失数组的实际类型，并且编译器可能会错过一些潜在的错误检查。
 * 因此，最好在集合中使用 Object[] ，并在 使用数组元素 时，向 T 添加强制类型转换。
 *
 * 优化方案：
 * 接 generics/GenericArray2.java
 *
 * @param <T>
 */
public class GenericArray<T> {

    private T[] array;


    @SuppressWarnings("unchecked")
    // 我们不能说 T[] array = new T[sz] ，所以我们创建了一个 Object数组并将其强制转换。
    // 该信息 仅在 编译时 存在，
    // 在 运行时，它仍然是一个Object 数组 ！！！
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];  // 强转仅 编译期 有效
    }


    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }


    public static void main(String[] args) {

        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.rep();  // 运行时报错
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // This is OK:
        Object[] oa = gai.rep();

    }

}
/* Output:
[Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
*/
