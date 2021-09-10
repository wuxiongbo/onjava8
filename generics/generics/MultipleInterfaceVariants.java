// generics/MultipleInterfaceVariants.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}
package generics;

interface Payable<T> {}


/**
 * 一个类不能实现同一个泛型接口的两种变体
 */

// Hourly 不能编译，因为擦除会将 Payable<Employe> 和 Payable<Hourly> 简化为相同的接口 Payable，
// 这样，就意味着在重复两次地实现相同的接口。
class Employee implements Payable<Employee> {}
//class Hourly extends Employee implements Payable<Hourly> {}
class Hourly extends Employee implements Payable<Employee> {}



// 十分有趣的是，如果从 Payable 的两种用法中都移除掉泛型参数（就像编译器在擦除阶段所做的那样）这段代码就可以编译。
class Employee1 implements Payable {}
class Hourly1 extends Employee1 implements Payable {}
