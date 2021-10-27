// generics/GenericArray2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


/**
 * 接 generics/GenericArray.java
 *
 * 创建泛型类型的数组： 在集合中使用Object[] ，在 使用数组元素 时 再强转 为泛型，使用数组 时 再强转为 泛型类型数组
 *
 * 存在问题：
 * 调用 rep() 时，再次尝试将 Object[] 强制转换为 T[] ，这仍然不正确，并 在“编译时”生成 警告，在“运行时”生成 异常。
 * 因此，无法破坏 基础数组的类型，该 基础数组 只能是 Object[] 。
 *
 * 在内部将数组视为 Object[] 而不是 T[] 的优点是：
 *    我们不太可能会 因为 忘记数组的 运行时类型 而 意外地引入了 bug， 尽管大多数（也许是全部）此类错误会在运行时被迅速检测到。
 *
 * 接 generics/GenericArrayWithTypeToken.java
 * @param <T>
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        // 将 Object[] 强转为 T[] 的操作从构造方法转移到了rep()方法。这仍然不正确，基础数组 只能是 Object[]
        return (T[]) array; // Unchecked cast
    }


    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);


        // 测试 put get 方法。 正常
        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();


        // 测试 rep 方法
        try {
            Integer[] ia = gai.rep(); // 运行异常
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
java.lang.ClassCastException: [Ljava.lang.Object;
cannot be cast to [Ljava.lang.Integer;
*/
