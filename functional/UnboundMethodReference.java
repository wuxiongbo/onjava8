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
 *
 * 方法签名不相同的引用（未绑定方法引用）
 *
 *
 * [1] 我们尝试对 X 中的 f() 做同样的事情，将其赋值给 MakeString。
 *     编译器会报错，提示“无效方法引用”（invalid method reference），即使  make()的 签名 和 f() 相同
 *
 *     问题在于，这里，事实上还涉及另一个（隐藏的）参数： 我们的老朋友 this。
 *     如果，没有一个可供附着的  X对象，就无法调用 f()。
 *     因此，X::f 代表的是一个 未绑定方法引用，因为，它没有“绑定到”某个对象。
 *
 *     为解决这个问题，我们需要一个 X对象 ，所以，我们的接口事实上还需要一个额外的参数，如 TransformX 中所示。
 *     如果，将 X::f 赋值给一个 TransformX ，Java会开心地接受。
 *
 *     在未绑定引用的情况下，函数式方法（接口中的单一方法）的 签名 与 方法引用的 签名 不再完全匹配。
 *
 *     这样做有一个很好的理由，那就是 —————— 我们需要一个对象，让方法绑定到其上调用。
 *
 * [2] 处的结果有点儿像“脑筋急转弯”。
 *     我们接受了 未绑定引用，然后，以 X 为参数，在 TransformX 上调用了transform()，最终，以某种方式调用了x.f()。
 *     Java知道，它必须接受第一个参数，事实上就是this，并在它的上面调用该方法。
 *
 *
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
//         MakeString ms = X::f;                // [1]


        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));    // [2]
        // TransformX 的 transform 方法实现
        // 引用了，
        // X          的 f 方法实现


        System.out.println(x.f());              // Same effect
    }
}
/* Output:
X::f()
X::f()
*/
