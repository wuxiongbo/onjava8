// functional/Curry3Args.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

/**
 * 三个参数的 柯里化
 */
public class Curry3Args {
    public static void main(String[] args) {

        // 柯里化函数
        Function<String, // arg1
                Function<String, // arg2
                        Function<String, // arg3
                                String>  // result
                        >> sum =
                a -> b -> c -> a + b + c;

        // arg1
        Function<String,
                Function<String, String>> hi = sum.apply("Hi ");

        // arg2
        Function<String, String> ho = hi.apply("Ho ");

        // arg3
        String result = ho.apply("Hup");

        System.out.println(result);


        // 流式编程
        String result1 = sum.apply("Hi ").apply("Ho ").apply("Hup");


        System.out.println(result1);

    }
}
/* Output:
Hi Ho Hup
*/
