// generics/ClassCasting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.io.*;
import java.util.*;

// 为了解决 不恰当的警告，必须使用Java 5 引入的新的转型形式，即通过泛型类来转型：
// 但是，不能转型到实际类型（List<Widget> ）。
// 也就是说，不能声明：List<Widget>.class.cast(in.readobject())
// 甚至当你添加一个像下面这样的另一个转型时：(List<Widget>)List.class.cast(in.readobject()) 仍旧会得到一个警告。

public class ClassCasting {
//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        // Won't Compile:
//    List<Widget> lw1 = List<>.class.cast(in.readObject());

        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
