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
 *
 * 自限定泛型事实上将产生 “确切的导出类型” 作为其返回值
 *
 * get的角度看。自限定类型 能否强制 返回 确切的导出类型
 *
 */
public class GenericsAndReturnTypes {
    void test(Getter g) {

        Getter result = g.get();

        // 也可以是基类
        GenericGetter gg = g.get(); // Also the base type
    }
}
