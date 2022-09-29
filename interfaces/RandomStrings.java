// interfaces/RandomStrings.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Implementing an interface to conform to a method

import java.nio.*;
import java.util.*;

public class RandomStrings implements Readable {
    private static Random rand = new Random(47);

    // 大写字母
    private static final char[] CAPITALS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    // 小写字母
    private static final char[] LOWERS =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    // 元音字母
    private static final char[] VOWELS =
            "aeiou".toCharArray();
    private int count;

    public RandomStrings(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1; // 表示输入结束
        cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
            cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }
        cb.append(" ");
        return 10;  // 添加到缓冲区的char值的数量，如果此字符源位于其末尾，则为 -1
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomStrings(10));
        while (s.hasNext())
            System.out.println(s.next());
    }
}
/* Output:
Yazeruyac
Fowenucor
Goeazimom
Raeuuacio
Nuoadesiw
Hageaikux
Ruqicibui
Numasetih
Kuuuuozog
Waqizeyoy
*/
