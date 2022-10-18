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
 * 上接 generics/OrdinaryArguments.java
 *
 * 自限定
 *
 * 自限定方法参数的 示例
 *
 * 自限定 方法参数 ，解决了 因 方法参数 不具备协变能力 而导致 ‘方法重载’ ，使 ‘一个方法名’ 产生 ‘多个版本’ 的问题。
 *
 *
 * 在 使用 “自限定类型” 约束后，
 *    ‘导出类’(Setter) 中只有 ‘一个set()方法’，并且 ‘这个set()方法’ 接受的参数是 ‘导出类型’(Setter) 而不是 ‘基类型’(SelfBoundSetter)
 *
 *
 * 关于自限定，个人总结：
 *  1.使用自限定，能避免 因 “方法重载” 产生同名方法的歧义 而难以选择 。
 *    使 方法  输入/输出  一个 确切的类型 的版本。
 *  2.使用自限定，能强制基类的方法 参数或返回类型 使用正在定义的派生类自身。
 *    即，基类方法参数的类型 随子类型 变化
 *    如 {@link Enum#compareTo(Enum)}
 *
 *
 * 如果 不使用 自限定类型，普通的 继承机制 就会介入，而导致 “重载” ，就跟在 非泛型 的情况下(下示例)  一样
 *
 * 见：  generics/PlainGenericInheritance.java
 * @see PlainGenericInheritance
 */
public class SelfBoundingAndCovariantArguments {


    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {

        // 基类方法只能传入派生类自身类型作为参数
        s1.set(s2);


        // 使用了自限定。 传入基类类型 会编译错误
        // 编译器无法识别出 想要将 基类类型 作为参数 传入set()的意图，
        // 因为，并不存在匹配 这种签名的方法。该参数实际上已经被重写了。
        // 使用自限定，将只能获得方法的一个版本，它将接受 确切的参数类型。  传入 “基类” 会编译报错。
//        s1.set(sbs);

    }

    public static void main(String[] args){

        // 派生类
        Setter s1 = arg -> System.out.println("s1.set()");
        Setter s2 = arg -> System.out.println("s2.set()");

        // 基类
        SelfBoundSetter sbs = arg -> System.out.println("sbs.set()");


        // 测试
        new SelfBoundingAndCovariantArguments()
                .testA(s1,s2,sbs);
    }

}
/*
 * s1.set()
 */