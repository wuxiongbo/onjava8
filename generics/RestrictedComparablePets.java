// generics/RestrictedComparablePets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 泛型存在的问题5：基类劫持接口
 *
 * Hamster（仓鼠） 展示了 重新实现 ComparablePet 相同的接口是可行的，只要接口（包括参数类型）完全相同。
 * Gecko（壁虎） 以上实现方式 与 “直接覆写 基类 的方法”  完全相同。
 *
 * 结论： 基类(ComparablePet)  劫持了  接口(Comparable)
 */
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
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


