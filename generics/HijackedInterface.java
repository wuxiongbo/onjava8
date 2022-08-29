// generics/HijackedInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 上接 generics/ComparablePet.java
 * @see  ComparablePet
 *
 * 泛型存在的问题5：基类劫持接口
 *
 * Hijacked 被劫持的   pet 宠物
 *
 * 可能会有这样的场景，我们需要将 Cat类 与 其他的Cat类 进行比较，
 * 在这种情况下，尝试 将 ComparablePet 的比较类型 缩小为 子类 Cat类 ，是有意义的。
 *
 * 然而，实际上，这样做并不能工作。
 * 一旦将 Comparable 的类型参数设置为 ComparablePet ，其他的实现类 就只能比较 ComparablePet
 *
 * 下接 generics/RestrictedComparablePets.java
 */
//class Cat
//         extends ComparablePet implements Comparable<Cat> {
//
//    @Override
//    public int compareTo(Cat arg) {
//        return 0;
//    }
//
//}
