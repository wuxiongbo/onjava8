// hiding/ChocolateChip.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// 无法在 另一个包里 调用 包访问权限的成员

import dessert.*;

public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    // 即便是子类，也无法访问 包访问权限成员
    public void chomp() {
//         bite(); // 无法访问bite
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
/* Output:
Cookie constructor
ChocolateChip constructor
*/
