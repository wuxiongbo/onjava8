// generics/SelfBoundingAndCovariantArguments.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}


/**
 * OrdinaryArguments 对比 SelfBoundingAndCovariantArguments
 *
 *
 * 使用自限定类型时：  本示例
 *      在导出类中只有一个方法，并且这个方法接受 导出类型(Setter) 而不是 基类型(SelfBoundSetter) 为参数
 *
 * 如果不使用自限定类型： PlainGenericInheritance.java
 *      普通的继承机制就会介入，而你将能够重载，就跟 在非泛型的情况下(OrdinaryArguments.java)  一样
 *
 *
 *  个人总结： 使用自限定，能防止方法的重载。 使方法使用确切的类型
 */
public class SelfBoundingAndCovariantArguments {


    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);

        // 使用了自限定。将只能获得方法的一个版本，他讲接受确切的参数类型。  传入基类会编译报错。
//        s1.set(sbs);

    }


}
