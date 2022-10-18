// reflection/ClassInitialization.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

/**
 * 1.使用.class语法， 来获取 对类的引用，不会导致初始化。
 *   而Class.forName()，会立即 初始化类，以产生 Class引用
 *
 * 2.static final 字段
 *   Initable.STATIC_FINAL   为 "编译时常量"，不需要初始化 Initable类
 *   Initable.STATIC_FINAL2  不是 "编译时常量"，需要初始化 Initable类
 *
 * 3.static 非 final 字段
 *   访问此类字段，总是需要先进行 链接（为字段分配存储）和  初始化（初始化该存储）
 *
 *
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {

        // 触发初始化。
//        Class<?> initable1 = Class.forName("Initable");
        System.out.println("---------");
        // 不会触发初始化。  Initable
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // final修饰的静态变量， 不会触发初始化。  Initable
        System.out.println(Initable.STATIC_FINAL);
        System.out.println();
        // 触发初始化。     Initable
        System.out.println(Initable.STATIC_FINAL2);
        System.out.println();


        // 非final修饰的静态变量， 触发初始化。  Initable2
        System.out.println(Initable2.staticNonFinal);
        System.out.println();


        // 触发初始化
        Class initable3 = Class.forName("Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println();
        // 触发初始化
        System.out.println(Initable3.staticNonFinal);
    }
}
/* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*/
