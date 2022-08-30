// generics/Erased.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 创建泛型的实例
 *
 * Erased  擦除
 *
 * 因为泛型擦除，我们将失去执行泛型代码中某些操作的能力。
 *
 * 1.无法在 ‘运行时’ 知道 确切类型
 *
 * 2.无法 new T()
 *   如代码所示，试图在 Erased.java 中 new T() 是行不通的，原因是：
 *      一是 由于泛型擦除，
 *      二是 编译器无法验证 T 是否具有默认（无参）构造函数。
 *   但是，在 C++ 中，此操作 非常的 自然、直接 且 安全
 *   见： generics/InstantiateGenericType.cpp
 *
 * 3.无法 创建 泛型数组
 *
 *
 * 一些情况下，我们可以对这些问题进行编程，
 * 但有些情况，我们必须通过 引入 “类型标签” 来补偿擦除。
 *          引入“类型标签” 意味着，为所需的类型 显式传递一个 Class 对象，以便在类型表达式中使用它。
 *
 *
 *
 * 下接  “类型标签” 的两个示例：
 *
 *       泛型类型 的判断
 *       {@link ClassTypeCapture}
 *       泛型类型 的实例化
 *       {@link InstantiateGenericType}
 *
 *
 * 如何 创建 泛型数组？
 *
 *       使用集合
 *       generics/ListOfGenerics.java
 *       使用“通用引用”
 *       generics/ArrayOfGenericReference.java
 *
 * @param <T>
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {

        // 由于 类型信息 T 被擦除了，因此，使用instanceof的尝试失败了。
        // 类型标签Class，则可以提供动态的 isInstance() 能力
        // error: illegal generic type for instanceof
//        if(arg instanceof T) {}

        // error: unexpected type
//        T var = new T();

        // error: generic array creation
//        T[] array = new T[SIZE];

        // warning: [unchecked] unchecked cast
        T[] array = (T[]) new Object[SIZE];

    }


}
