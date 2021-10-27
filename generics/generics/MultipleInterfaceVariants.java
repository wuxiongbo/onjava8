// generics/MultipleInterfaceVariants.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}
package generics;


/**
 * 泛型存在的问题2：实现 参数化接口 出现冲突
 *
 * 一个类不能实现 同一个泛型接口 的两种变体
 * 但是，可以重复两次地实现相同的 非泛型接口
 *
 */

// 定义接口
interface Payable<T> {}


// 基类
class Employee implements Payable<Employee> {}
// 派生类。不能编译。这是因为，擦除 会将 Payable<Employe> 和 Payable<Hourly> 简化为相同的接口 Payable，这意味着，重复两次实现相同的接口。
//class Hourly extends Employee implements Payable<Hourly> {}  // 编译错误
class Hourly extends Employee implements Payable<Employee> {}  // ok


// 不过，十分有趣的是，如果 将 基类、衍生类 分别实现的Payable接口，都移除掉 泛型参数（就像编译器在擦除阶段所做的那样），这段代码就可以编译。
class Employee1 implements Payable {}
class Hourly1 extends Employee1 implements Payable {}
