// interfaces/MICollision.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

interface Bob1 {
    default void bob() {
        System.out.println("Bob1::bob");
    }
}

interface Bob2 {
    default void bob() {
        System.out.println("Bob2::bob");
    }
}

//class Bob implements Bob1, Bob2 {}

/* Produces:
error: class Bob inherits unrelated defaults
for bob() from types Bob1 and Bob2
class Bob implements Bob1, Bob2 {}
^
1 error
*/



interface Sam1 {
    default void sam() {
        System.out.println("Sam1::sam");
    }
}

interface Sam2 {
    default void sam(int i) {
        System.out.println(i * 2);
    }
}

/**
 * 在Sam类中，两个sam()方法具有相同的名称，但它们的 方法签名 是唯一的——————签名 包括 "名称" 和 "参数类型"，编译器用它来区分不同的方法。
 * 但是，正如Max类所示，返回类型  不是 方法签名 的一部分，因此不能用于区分两个方法
 */
// This works because the argument lists are distinct:
class Sam implements Sam1, Sam2 {
}


interface Max1 {
    default void max() {
        System.out.println("Max1::max");
    }
}

interface Max2 {
    default int max() {
        return 47;
    }
}

//class Max implements Max1, Max2 {}
/* Produces:
error: types Max2 and Max1 are incompatible;
both define max(), but with unrelated return types
class Max implements Max1, Max2 {}
^
1 error
*/
