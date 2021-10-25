// generics/SelfBoundingAndCovariantArguments.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 代码解读： 限制 T 必须为 自限定类型
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

// 代码解读： 当前定义的 Setter类  是  自限定类型
interface Setter extends SelfBoundSetter<Setter> {
}


/**
 * 接 OrdinaryArguments 对比 SelfBoundingAndCovariantArguments
 *
 *
 * 使用自限定类型时：  本示例
 *      在导出类中，只有一个方法，并且 这个方法接受 导出类型(Setter) 而不是 基类型(SelfBoundSetter) 为参数
 *
 * 如果不使用自限定类型： PlainGenericInheritance.java
 *      普通的继承机制就会介入，而你将能够重载，就跟在 非泛型 的情况下(OrdinaryArguments.java)  一样
 *
 *
 * 个人总结： 使用自限定，能防止方法的重载。 使方法使用确切的类型
 */
public class SelfBoundingAndCovariantArguments {


    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {

        s1.set(s2);

        // 使用了自限定。将只能获得方法的一个版本，它将接受确切的参数类型。  传入 “基类” 会编译报错。
//        s1.set(sbs);

    }

    public static void main(String[] args){

        Setter s1 = arg -> System.out.println("s1.set()");

        Setter s2 = arg -> System.out.println("s2.set()");

        SelfBoundSetter sbs = arg -> System.out.println("sbs.set()");

        new SelfBoundingAndCovariantArguments()
                .testA(s1,s2,sbs);
    }

}
