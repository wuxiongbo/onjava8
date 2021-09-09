// generics/ListMaker.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

public class ListMaker<T> {

    // 在 create() 内部的 new ArrayList<>() 中的 <T> 被移除了，—在运行时，类内部没有任何 <T>，因此这看起来毫无意义。
    List<T> create() {

        return new ArrayList<>();

        //但是如果你遵从这种思路，并将这个表达式改写，编译器就会警告
//        return new ArrayList();
    }



    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();

    }
}
