// generics/CRGWithBasicHolder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


class Subtype extends BasicHolder<Subtype> {
}

/**
 * 接 generics/BasicHolder.java
 *
 * 自限定类型：
 *   BasicHolder 的 自限定 示例
 *
 *
 * 注意，这里有些东西很重要：
 *      新定义的 Subtype类  接受的 ‘参数’ 和 ‘返回值’  是确切的Subtype类型 而不仅仅是 基类 BasicHolder 类型。
 * 这就是 CRG 的本质：
 *      泛型基类(BasicHolder)  用 导出类(Subtype)  替代其 泛型参数。
 *      “基类  用  子类  替换了其 参数”
 *
 * 这意味着，‘泛型基类’(BasicHolder)  变成了一种  所有‘导出类’(如Subtype)  的公共功能的模版，
 * 而且，这些功能对于其所有 ‘参数’ 和 ‘返回值’ ，都将使用 ‘导出类’ 。
 *
 * 因此，在  导出类Subtype  中，传递给 set() 的参数和从 get() 返回的类型都是确切的 Subtype。
 *
 * generics/Unconstrained.java
 */
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(),
                st2 = new Subtype();

        //  ‘参数’ 和 ‘返回值’，“类型都是Subtype，而不只是基类BasicHolder
        st1.set(st2);
        Subtype st3 = st1.get();

        st1.f();

    }
}
/* Output:
Subtype
*/
