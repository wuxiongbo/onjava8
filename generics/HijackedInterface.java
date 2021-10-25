// generics/HijackedInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 示例： 基类 劫持 接口
 *
 * 上接 generics/ComparablePet.java
 *
 * 我们可能会 需要 Cat 类可以与其他的 Cat 比较， 而尝试 缩小 ComparablePet 子类的比较类型 ，这样做是有意义的。
 *
 * 然而，实际上这不能工作。 一旦 Comparable 的类型参数设置为 ComparablePet，其他的实现类 只能比较 ComparablePet
 *
 */

// error: Comparable cannot be inherited with different arguments: <Cat> and <ComparablePet>
// class Cat
// ^
// 1 error

//class Cat extends ComparablePet implements Comparable<Cat> {
//
//    @Override
//    public int compareTo(Cat arg) {
//        return 0;
//    }
//
//}
