// generics/GenericsAndReturnTypes.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 基类
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

// 自限定 强制  泛型参数 为 正在定义的类。
interface Getter extends GenericGetter<Getter> {
}

/**
 * generics/CovariantReturnTypes.java
 *
 * 自限定
 * 返回类型的 参数协变  与  方法参数的 自限定
 *
 * 本示例： 自限定后，返回类型的 参数协变
 *
 *
 * 协变返回类型 的引入，使  ‘重写的子类方法’ 返回  比 ‘被覆盖的父类方法‘ 返回  更具体的类。
 *
 * 使用 “自限定泛型” 将产生 “确切的导出类型”  作为其 ‘返回值’
 *
 *
 * 非泛型演示： 原始类型方法参数的 示例
 *  generics/OrdinaryArguments.java
 *
 */
public class GenericsAndReturnTypes {
    void test(Getter g) {

        // 自限定泛型类  返回了 更加具体的类。
        Getter result = g.get();

        // 自限定泛型类  返回的 也可以是 更加泛化的基类。
        GenericGetter gg = g.get();


        // 协变返回类型，带来的好处：
        //     子类Getter 的 get方法 返回的是 Getter类
        //     父类GenericGetter 的 get方法 返回的是  泛型参数被擦除到的边界类型 GenericGetter类
        //     也就是说，子类 返回了 更具体的类型，
        //          可通过 子类 ‘覆盖’ 父类方法  的方式来实现，
        //          而非  ‘重载’

    }
}
