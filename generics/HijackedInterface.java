// generics/HijackedInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 示例： 基类 劫持 接口。    Hijacked 被劫持的
 *
 * 上接 generics/ComparablePet.java
 *
 * 可能会有这样的场景，我们需要将 Cat类 与 其他的Cat类 进行比较，
 * 在这种情况下，尝试 缩小 ComparablePet子类 的比较类型 为 Cat类 ，是有意义的。
 *
 * 然而，实际上，这样做并不能工作。
 * 一旦将 Comparable 的类型参数设置为 ComparablePet ，其他的实现类 就只能比较 ComparablePet
 *
 */
//class Cat extends ComparablePet implements Comparable<Cat> {
//
//    @Override
//    public int compareTo(Cat arg) {
//        return 0;
//    }
//
//}
