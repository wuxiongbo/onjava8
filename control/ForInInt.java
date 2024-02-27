// control/ForInInt.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import static Range;

public class ForInInt {
  public static void main(String[] args) {
      // 0..9
    for(int i : range(10)) {
        System.out.print(i + " ");
    }
    System.out.println();
    // 5..9
    for(int i : range(5, 10)) {
        System.out.print(i + " ");
    }
    System.out.println();
      // 5..20 step 3
    for(int i : range(5, 20, 3)) {
        System.out.print(i + " ");
    }
    System.out.println();
      // Count down
    for(int i : range(20, 5, -3)) {
        System.out.print(i + " ");
    }
    System.out.println();
  }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
5 6 7 8 9
5 8 11 14 17
20 17 14 11 8
*/
