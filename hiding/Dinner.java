// hiding/Dinner.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Uses the library

import dessert.*;

/**
 * 现在可以创建一个程序 Dinner（晚餐） ，来使用Cookie（饼干） 了：
 *
 * bite()方法在Dinner.java中是不可访问的。
 *
 * 因为  bite()  只提供了在包 dessert(甜点) 中的访问权限，
 * 所以， 在包 dessert 以外的地方  编译器会阻止你使用它。
 *
 * hiding/Cake.java
 */
public class Dinner {

    public static void main(String[] args) {

        Cookie x = new Cookie();

//        x.bite(); // 无法访问

    }

}
/* Output:
Cookie constructor
*/
