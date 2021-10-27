// generics/Unconstrained.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Other {
}
class BasicOther extends BasicHolder<Other> { // BasicHolder的 <T> 没有作约束限制，所以可以使用任意类作为导出类。
}

/**
 * generics/CRGWithBasicHolder.java
 *
 *
 * 不作自限定，让 BasicHolder 可使用任何类型作为其泛型参数
 *
 * BasicHolder的 <T> 没有作约束限制，所以可以使用任意类作为导出类。
 *
 * 限定 将采取额外的步骤，强制泛型当作其自身的边界参数来使用。
 * 自限定，见： generics/SelfBounding.java
 */
public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();

        // ‘参数’ 和 ‘返回值’  可以是任意其他类（Other）
        b.set(new Other());
        Other other = b.get();

        b.f();
    }
}
/* Output:
Other
*/
