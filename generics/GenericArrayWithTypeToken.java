// generics/GenericArrayWithTypeToken.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;

/**
 * 接 generics/GenericArray2.java
 *
 * 创建泛型类型的数组： 传入 “类型标记”
 *
 * 为了将 传递到‘构造函数’中的 类型标记Class<T> 从擦除中恢复，因此须进行 强制类型转换，
 * 尽管必须使用 @SuppressWarnings 关闭强转警告，但我们仍可以创建所需的实际数组类型。
 *
 * 一旦获得了实际的类型，就可以 返回它 并 产生所需的结果，如在主方法中看到的那样。
 * 数组的 “运行时类型” 是确切的类型 T[] 。
 *
 * @param <T>
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {

        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();

    }
}
