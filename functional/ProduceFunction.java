// functional/ProduceFunction.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

/**
 * 高阶函数，只是一个  能接受函数作为参数  或   能把函数当返回值的函数。
 *
 * 这里 produce() 就是高阶函数。
 *
 * [1] 使用继承，可以轻松地为专门的接口创建一个别名。
 * [2] 有了lambda表达式，在方法中创建并返回一个函数简直不费吹灰之力。
 *
 */
interface FuncSS extends Function<String, String> { // [1]
}

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();                // [2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
/* Output:
yelling
*/
