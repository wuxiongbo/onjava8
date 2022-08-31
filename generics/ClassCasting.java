// generics/ClassCasting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * generics/NeedCasting.java
 *
 * 泛型存在的问题3：转型和警告
 * 不恰当的警告
 *
 * 为了解决 不恰当的警告，必须使用Java 5 引入的新的转型形式，即通过泛型类来转型：
 *
 *  但是，不能转型到 实际类型（List<Widget> ）。
 *  也就是说，不能声明：
 *      List<Widget>.class.cast(in.readobject())
 *
 *  甚至，当你添加一个像下面这样的另一个转型时：
 *      (List<Widget>)List.class.cast(in.readobject())
 *
 *  仍旧会得到一个警告。
 *
 */
public class ClassCasting {

    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(args[0])));

        // 无法编译
//        List<Widget> lw1 = List<Widget>.class.cast(in.readObject());
//        List<Widget> lw1 = List<>.class.cast(in.readObject());


        List<Widget> lw2 = List.class.cast(in.readObject());


        // 无法这么做
//        List<Widget> lw3 = List<Widget>.class.cast(in.readObject());

        // 即使你像这样再增加一层转型也还是会产生警告
        List<Widget> lw4 = (List<Widget>)List.class.cast(in.readObject());


    }

}
