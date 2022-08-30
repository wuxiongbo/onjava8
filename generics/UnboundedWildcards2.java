// generics/UnboundedWildcards2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 *   无界通配符
 *
 *   Map   Map
 *   Map<?, ?>   Map<?, ?>
 *   Map<String, ?>   Map<String, ?>
 *
 *   <?> 的意义
 *   当处理多个泛型参数时，有时允许一个参数可以是任何类型，同时为其他参数确定某种特定类型。（如 map3 所示）这种能力会显得很重要
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        // 原生 Map   原生 Map
        assign1(new HashMap());

        // 编译器无法将 Map<?,?> 与 原生 Map 区分开
        assign2(new HashMap(16));

        // 但能将 Map<String,?> 与 原生 Map 区分开
        assign3(new HashMap(16));

        // 这也说明了 <?> 在某些场景下是有意义的。


        assign1(new HashMap<>(16));
        assign2(new HashMap<>(16));
        assign3(new HashMap<>(16));





        // 更直观的写法
        Map map1 = new HashMap(16);
        Map<?, ?> map2 = new HashMap(16);
        Map<String, ?> map3 = new HashMap(16);


        Map map11 = new HashMap<>(16);
        Map<?, ?> map22 = new HashMap<>(16);
        Map<String, ?> map33 = new HashMap<>(16);


    }
}
