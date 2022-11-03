// functional/UnboundMethodReference.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method reference without an object

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

/**
 * 在未绑定引用的情况下，函数式方法（接口中的单一方法）的签名与方法引用的签名不再完全匹配。
 *
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
//         MakeString ms = X::f;                // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));    // [2]
        System.out.println(x.f()); // Same effect
    }
}
/* Output:
X::f()
X::f()
*/
