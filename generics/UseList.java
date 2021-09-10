// generics/UseList.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.*;

// 泛型不能重载

// 下面的程序是不能编译的，即使它看起来是合理的：
// 因为擦除，所以重载方法产生了相同的类型签名。
public class UseList<W, T> {
    void f(List<T> v) {}

//    void f(List<W> v) {}
}
