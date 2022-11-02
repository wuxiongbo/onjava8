// functional/RecursiveFactorial.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 递归
 * 阶乘
 */
public class RecursiveFactorial {
//  不能在定义的时候像这样来初始化fact, 尽管这样的期望非常合理，但是对于Java编译器而言处理起来太复杂了，所以会产生编译错误。
//    static IntCall fact = n -> n == 0 ? 1 : n * fact.call(n - 1);

    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);

        for (int i = 0; i <= 10; i++)
            System.out.println(fact.call(i));

    }

    //整数n的阶乘
    int call(int n){
        return n == 0 ? 1 : n * call(n - 1);
    }


}
/* Output:
1
1
2
6
24
120
720
5040
40320
362880
3628800
*/
