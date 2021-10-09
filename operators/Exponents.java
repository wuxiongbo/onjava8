// operators/Exponents.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// "e" means "10 to the power."

/**
 * "e" 表示 10 的几次幂
 *
 * 在科学与工程学领域，e 代表自然对数的基数，约等于 2.718 （Java 里用一种更精确的 double 值 Math.E 来表示自然对数）。
 * 指数表达式 “1.39e-43”，意味着 “1.39 × 2.718 的 -43 次方”。
 *
 * 然而，自 FORTRAN 语言发明后，人们自然而然地觉得 e 代表“10 的几次幂”。
 * 这种做法显得颇为古怪，因为 FORTRAN 最初是为科学与工程领域设计的。
 *
 * 在 Java 中看到类似 “1.39e-43f” 这样的表达式时，请转换你的思维，从程序设计的角度思考它；
 * 它真正的含义是 “1.39 × 10 的 -43 次方”。
 *
 */
public class Exponents {
    public static void main(String[] args) {
        // 大写 E 和小写 e 的效果相同:
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d; // 'd' 是可选的
        double expDouble2 = 47e47; // 自动转换为 double
        System.out.println(expDouble);
    }
}
/* Output:
1.39E-43
4.7E48
*/
