// generics/HijackedInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 尝试缩小 ComparablePet 子类的比较类型是有意义的。
 * 例如，Cat 类可以与其他的 Cat 比较：
 * 不幸的是，这不能工作。
 * 一旦 Comparable 的类型参数设置为 ComparablePet，其他的实现类只能比较 ComparablePet
 */
//class Cat extends ComparablePet implements Comparable<Cat> {

    // error: Comparable cannot be inherited with
    // different arguments: <Cat> and <ComparablePet>
    // class Cat
    // ^
    // 1 error

//    public int compareTo(Cat arg) {
//        return 0;
//    }
//}
