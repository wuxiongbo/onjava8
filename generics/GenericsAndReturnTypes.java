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
 * 协变返回类型的引入， 使 子类方法 能够返回 比 被覆盖的父类方法 所返回的类  更具体的类。
 *
 * 自限定泛型事实上将产生 “确切的导出类型” 作为其返回值
 *
 *
 */
public class GenericsAndReturnTypes {
    void test(Getter g) {

        // 返回了更加具体的类
        Getter result = g.get();

        GenericGetter gg = g.get(); // Also the base type

    }
}
