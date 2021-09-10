// generics/NeedCasting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.io.*;
import java.util.*;

// 有时，泛型没有消除对转型的需要，这就会由编译器产生警告，而这个警告是不恰当的。
// 你会被强制要求转型，但是又被告知不应该转型
public class NeedCasting {
//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));

        List<Widget> shapes = (List<Widget>) in.readObject(); // unchecked cast
    }
}
