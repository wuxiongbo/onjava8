// generics/GenericsAndReturnTypes.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

// 自限定 强制  泛型参数 为 正在定义的类。
interface Getter extends GenericGetter<Getter> {
}

/**
 * // generics/CovariantReturnTypes.java
 *
 * 自限定
 * 参数协变  引入自限定
 *
 *
 * 协变返回类型 的引入，使 ‘子类方法’ 能够 比 ‘被覆盖的父类方法‘  返回更具体的类。
 *
 * 使用 “自限定泛型” 将产生 “确切的导出类型”  作为其 ‘返回值’
 *
 *
 * 非泛型演示：
 *  generics/OrdinaryArguments.java
 *
 */
public class GenericsAndReturnTypes {
    void test(Getter g) {

        // 返回了更加具体的类
        Getter result = g.get();

        // 也可以是 基类
        GenericGetter gg = g.get();

    }
}
