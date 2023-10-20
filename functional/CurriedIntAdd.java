// functional/CurriedIntAdd.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

public class CurriedIntAdd {
    public static void main(String[] args) {

        IntFunction<IntUnaryOperator>
                curriedIntAdd = a -> b -> a + b;

        IntUnaryOperator add4 =
                curriedIntAdd.apply(4);

        println(
                add4.applyAsInt(5)
        );
    }

    private static void println(Object s){
        System.out.println(s);
    }
}
/* Output:
9
*/
