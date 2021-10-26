// generics/Erased.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

/**
 * 因为泛型擦除，我们将失去执行泛型代码中某些操作的能力。无法在运行时知道确切类型
 *
 * 如代码所示，试图在 Erased.java 中 new T() 是行不通的，
 * 部分原因是 由于泛型擦除，
 * 部分原因是 编译器无法验证 T 是否具有默认（无参）构造函数。
 * 但是在 C++ 中，此操作 自然、直接且安全 generics/InstantiateGenericType.cpp
 *
 *
 * 有些情况，我们可以对这些问题进行编程，
 * 有些情况，我们必须通过 引入 “类型标签” 来补偿擦除。这意味着，为所需的类型显式传递一个 Class 对象，以在类型表达式中使用它。
 *
 *
 *  下接  generics/ClassTypeCapture.java
 *       generics/InstantiateGenericType.java
 *
 *       泛型数组
 *       generics/ListOfGenerics.java
 * @param <T>
 */
public class Erased<T> {
    private final int SIZE = 100;


    public void f(Object arg) {
        // error: illegal generic type for instanceof
//    if(arg instanceof T) {
//    }

        // error: unexpected type
//    T var = new T();

        // error: generic array creation
//    T[] array = new T[SIZE];

        // warning: [unchecked] unchecked cast
        T[] array = (T[]) new Object[SIZE];
    }


}
