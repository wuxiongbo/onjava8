// generics/NeedCasting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 泛型存在的问题3：转型和警告
 * 不恰当的警告
 * <p>
 * 在本示例的场景中，泛型并没有消除对转型的需要，这就会由编译器产生警告，而这个警告是不恰当的。
 * readObject() 无法知道它正在读取的是什么，因此它返回的是必须转型的对象。
 * <p>
 * 当注释掉 @SuppressWarnings 注解 编译这个程序时，就会得到警告
 * <p>
 * 此时，你 被强制要求转型 但 又被告知不应该转型
 * <p>
 * 为了解决这个问题，必须使用Java 5 引入的新的转型形式，即，通过 “泛型类” 来转型。
 * generics/ClassCasting.java
 */
public class NeedCasting {

//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(args[0])));

        List<Widget> shapes = (List<Widget>) in.readObject(); // unchecked cast
    }
}
