// streams/Randoms.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * ints()方法会生成一个流，该方法有多个重载版本，其中两个参数的版本可以设置所生成值的上下界
 *
 * 声明式编程 是一种编程风格，我们说明想要完成什么（what），而不是指明怎么做（how），这就是我们在函数式编程中看到的。
 *
 *
 * @author 10027088
 */
public class Randoms {
    public static void main(String[] args) {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }
}
/* Output:
6
10
13
16
17
18
19
*/
