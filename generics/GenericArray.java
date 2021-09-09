// generics/GenericArray.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class GenericArray<T> {

    private T[] array;


    @SuppressWarnings("unchecked")
    // 我们不能说 T[] array = new T[sz] ，所以我们创建了一个 Object数组并将其强制转换。
    // 该信息 仅在 编译时 存在，在 运行时，它仍然是一个Object 数组
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
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
            Integer[] ia = gai.rep();
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
