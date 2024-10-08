// generics/InstantiateGenericType.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;
import java.lang.reflect.InvocationTargetException;

class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            // “类型标记” 可直接使用 newInstance()方法 创建该类型的新对象。
            return kind.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

class Employee {
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee";
    }
}

/**
 * 上接 {@link ClassTypeCapture}
 *
 * 补偿擦除 之 泛型类型的实例化方案一：
 * 对于 泛型擦除 的 补偿： 引入 “类型标签”
 * 本示例：对 泛型类型 的实例化
 *
 * Class对象就是一个方便的工厂对象，
 * 因此，如果你使用了 类型标签，便可以通过 newInstance() 来创建该类型的新对象
 *
 *
 * @see FactoryConstraint
 */
public class InstantiateGenericType {

    public static void main(String[] args) {

        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.get());


        // 对于 ClassAsFactory<Integer> ，虽说可以编译，但会 运行失败，这是因为 Integer 没有无参构造函数。
        // 由于错误不是在 “编译时” 捕获的，因此语言创建者不赞成这种方法。
        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);

        try {
            System.out.println(fi.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 他们建议使用 显式工厂（Supplier） 并 约束类型，以便只有实现该工厂的类可以这样创建对象。
        // 见： generics/FactoryConstraint.java

    }

}

/* Output:
Employee
java.lang.NoSuchMethodException: java.lang.Integer.<init>()
*/
