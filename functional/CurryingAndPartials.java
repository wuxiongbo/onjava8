// functional/CurryingAndPartials.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

/**
 * 柯里化（Currying）是以其发明者之一的Haskell Curry的姓氏命名的。
 * 而Haskell Curry也可能是唯一一位姓氏和名字都被用来命名重要事物的 计算机科学家，Haskell编程语言就是以他的名字命名的。
 * <p>
 * 柯里化的意思是，将一个接受多个参数的函数转变为一系列只接受一个参数的函数。
 *
 * @author 10027088
 */
public class CurryingAndPartials {
    // 未柯里化:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println(uncurried("Hi ", "Ho"));


        // 柯里化函数:
        Function<String, Function<String, String>> sum =
                a -> b -> a + b;                             // [1]

        Function<String, Function<String, String>> sum1 =    // 换个好理解的写法
                // 函数 1
                (a) -> {
                    return
                            // 函数 2
                            (b) -> {
                                return a + b;
                            };
                };


        Function<String, String> hi = sum.apply("Hi ");   // [2]
        System.out.println(hi.apply("Ho"));


        // 部分应用:
        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));

    }

}
/* Output:
Hi Ho
Hi Ho
Hup Ho
Hup Hey
*/
