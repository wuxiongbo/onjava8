// streams/Fibonacci.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.Stream;

/**
 * @author 10027088
 */
public class Fibonacci1 {
    int preValue = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, currentValue -> {
            int result = preValue + currentValue;
            System.out.println("result:" + result);

            preValue = currentValue;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci1().numbers()
                .limit(4)
                .forEach(System.out::println);
    }
}
/* Output:
6765
10946
17711
28657
46368
75025
121393
196418
317811
514229
*/
