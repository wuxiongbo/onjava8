// streams/ImperativeRandoms.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 像在ImperativeRandoms.java中这样显式地编写迭代机制，称为外部迭代。
 * <p>
 * 而在Randoms.java中，我们看不到任何这样的机制，所以这被称为内部迭代，这是流编程的一个核心特性。
 *
 * @author 10027088
 */
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
/* Output:
[7, 8, 9, 11, 13, 15, 18]
*/
