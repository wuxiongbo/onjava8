// generics/RestrictedComparablePets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 泛型存在的问题5：基类劫持接口
 *
 * Hamster（仓鼠） 展示了 重复实现 ComparablePet 中的相同的接口是可行的，只要接口（包括参数类型）完全相同即可。
 *
 * Gecko（壁虎） 展示了 “直接重写 基类 的方法”  的方式。
 *
 * 结论： 基类(ComparablePet)  劫持了  接口(Comparable) 的参数类型。
 *       子类 无法再次重写接口的参数类型
 *
 *       除非，重复实现 ComparablePet 中的相同的接口，
 *       但是，这和直接重写 基类中的接口  没有任何区别
 *
 */
class Hamster extends ComparablePet
        implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

// 直接复写基类的方法
class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}


