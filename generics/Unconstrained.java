// generics/Unconstrained.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Other {
}

class BasicOther extends BasicHolder<Other> {
}

/**
 * 对比 Unconstrained 与 SelfBounding
 *
 * BasicHolder 可以使用任何类型作为其泛型参数
 *
 */
public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();

        // 方法参数、返回类型 都是 基类（Other）
        b.set(new Other());
        Other other = b.get();

        b.f();
    }
}
/* Output:
Other
*/
