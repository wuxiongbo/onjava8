// generics/UseList2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

//当擦除后的参数不能产生唯一的参数列表时，你必须提供不同的方法名：
public class UseList2<W, T> {
    void f1(List<T> v) {}
    void f2(List<W> v) {}
}
