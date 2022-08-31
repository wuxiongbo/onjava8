// generics/UseList2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

// 在被擦除的参数无法生成独有的参数列表的情况下，你需要提供各不相同的方法名：
public class UseList2<W, T> {
    void f1(List<T> v) {}
    void f2(List<W> v) {}
}
