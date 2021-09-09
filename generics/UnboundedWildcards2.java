// generics/UnboundedWildcards2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

//  arg: new HashMap();   new HashMap<>();
//  Map
//      Map
//  Map<?, ?>
//      Map<?, ?>
//  Map<String, ?>
//      Map<String, ?>
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
        assign1(new HashMap());

        // 编译器无法将 Map<?,?> 与 原生 Map 区分开了
        assign2(new HashMap());

        // 但是，编译器能将 Map<String,?> 与 原生 Map 区分开
        assign3(new HashMap());

        // warning: [unchecked] unchecked method invocation:
        // method assign3 in class UnboundedWildcards2
        // is applied to given types
        //     assign3(new HashMap());
        //            ^
        //   required: Map<String,?>
        //   found: HashMap

        // warning: [unchecked] unchecked conversion
        //     assign3(new HashMap());
        //             ^
        //   required: Map<String,?>
        //   found:    HashMap

        // 2 warnings


        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }
}
