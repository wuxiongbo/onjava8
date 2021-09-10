// generics/CRGWithBasicHolder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * CRG 的本质：
 *      泛型基类(BasicHolder)  用 导出类(Subtype)  替代其 泛型参数。
 *
 * 这意味着，泛型基类(BasicHolder)变成了一种它所有导出类(如Subtype)的公共功能的模版，
 * 但是这些功能对于其所有参数和返回值，将使用导出类型。
 *
 * 因此，在 Subtype 中，传递给 set() 的参数和从 get() 返回的类型都是确切的 Subtype。
 */
class Subtype extends BasicHolder<Subtype> {
}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();

        //  参数和返回值，将使用导出类型(Subtype)
        st1.set(st2);
        Subtype st3 = st1.get();


        st1.f();
    }
}
/* Output:
Subtype
*/
