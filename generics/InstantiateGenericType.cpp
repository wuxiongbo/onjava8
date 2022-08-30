// generics/InstantiateGenericType.cpp
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// C++, not Java!

/*
    试图在 Erased.java 中 new T() 是行不通的，部分原因是由于擦除，部分原因是编译器无法验证 T 是否具有默认（无参）构造函数。
    但是在 C++ 中，此操作自然，直接且安全（在编译时检查）

    Java 中的解决方案是传入一个工厂对象，并使用该对象创建新实例。
    generics/InstantiateGenericType.java
*/

template<class T> class Foo {
    T x;  // Create a field of type T
    T* y; // 指向T的指针
    public:
      // 初始化指针 y ：
      Foo() { y = new T(); }
};

class Bar {};

int main() {
  Foo<Bar> fb;
  Foo<int> fi; // ……还可以使用基本类型
}
