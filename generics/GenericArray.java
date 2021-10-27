// generics/GenericArray.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 接  generics/ArrayOfGeneric.java
 *
 * 补偿 泛型擦除
 * 创建泛型类型的数组：先创建一个 ‘Object 数组’ 然后 立即转为 所需的数组类型
 *
 * 为了测试，先创建一个用于包装数组的 简单泛型包装器 GenericArray
 * 然后，我们在main方法中进行测试。
 *
 *
 * 存在的问题：
 * 我们知道，定义 rep()方法 的时候 返回的是 T[] ，那么，在main方法中，rep()方法 返回的 应该是 gai 的 Integer[]  。
 * 但是实际上，在main方法中调用rep()方法 并尝试将其结果转换为 Integer[] 引用 的时候，会得到 ClassCastException 异常
 * 这再次是因为实际的 运行时类型 为 Object[] 。
 *
 * 问题原因：
 * 由于擦除，数组的运行时类型只能是 Object[] 。
 * 如果我们立即将其转换为 T[] ，则在 编译时 会丢失数组的实际类型信息，并且 编译器 可能会错过一些潜在的错误检查。
 * 因此，最好在集合中使用 Object[] ，并在 使用数组元素 时，向 T 添加强制类型转换。
 *
 * 优化方案： 数组使用 Object[] ，使用 数组元素 时 再强转
 * 接 generics/GenericArray2.java
 *
 * @param <T>
 */
public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    // 我们不能 T[] array = new T[sz] ，所以创建Object数组并将其强转。强转后的类型信息 仅在 编译时 存在，在 运行时，它仍然是一个Object 数组
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

        gai.put(1,1);
        Integer element = gai.get(1);
        System.out.println(element);

        Object[] oa = gai.rep(); // 可以正常返回 Object[]
    }

}
/* Output:
[Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
*/
