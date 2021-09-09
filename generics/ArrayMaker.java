// generics/ArrayMaker.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;
import java.util.*;

public class ArrayMaker<T> {

    // 即使 kind 被存储为 Class<T>，擦除也意味着它实际被存储为没有任何参数的 Class
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    // 因此，当你在使用它时，例如创建数组，Array.newInstance() 实际上并未拥有 kind 所蕴含的类型信息。
    // 所以它不会产生具体的结果，因而必须转型，这会产生一条令你无法满意的 “警告” 。
//    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {

        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);

        System.out.println(Arrays.toString(stringArray));
    }
}
/* Output:
[null, null, null, null, null, null, null, null, null]
*/
