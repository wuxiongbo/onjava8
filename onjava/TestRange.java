// onjava/TestRange.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Basic test of onjava.Range.java

import onjava.Range;

import java.util.Arrays;

public class TestRange {
    private static void show(int[] rng) {
        System.out.println(Arrays.toString(rng));
    }

    public static void main(String[] args) {
        show(Range.range(10, 21, 3));
        show(Range.range(21, 10, -3));
        show(Range.range(-5, 5, -3));
        show(Range.range(-5, 5, 3));
        show(Range.range(10, 21));
        show(Range.range(10));
    }
}
/* Output:
[10, 13, 16, 19]
[21, 18, 15, 12]
[]
[-5, -2, 1, 4]
[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
