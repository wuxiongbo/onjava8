// generics/CuriouslyRecurringGeneric.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class GenericType<T> {
}

/**
 * 自限定类型：
 * 古怪的循环泛型（CRG）
 *
 * 按照 Jim Coplien 在 C++ 中的  古怪的循环模版模式  的命名方式，称为古怪的循环泛型（CRG）
 *
 * 下接 generics/BasicHolder.java
 */
public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {
}
