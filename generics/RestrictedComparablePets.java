// generics/RestrictedComparablePets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 基类劫持接口

// Hamster（仓鼠） 展示了 重新实现  ComparablePet 中相同的接口是可能的，只要接口完全相同，包括参数类型。
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

// Or just:

// 以上实现方式 与 “直接覆写 基类 的方法”  完全相同。
class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}



// 结论： 也就是说，基类(ComparablePet)  劫持了 接口(Comparable)