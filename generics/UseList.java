// generics/UseList.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.*;

/**
 * 泛型存在的问题4：泛型不能重载
 *
 * 下面的程序是不能编译的，即使它看起来是合理的：
 *     因为擦除，所以 “重载方法” 产生了相同的 类型签名。
 *
 *
 * 幸运的是，编译器可以检测到这类问题。
 *
 */
public class UseList<W, T> {

    void f(List<T> v) {}
//    void f(List<W> v) {}

}
