package mydemo1;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> Java中如何获取泛型的Class对象</p>
 *
 * 获取父类的参数化类型  示例
 *
 *
 * 虽然泛型会在字节码编译过程中被擦除，但是Class对象会通过java.lang.reflect.Type 记录其实现的接口和继承的父类信息。
 *
 *
 * 抽取的 工具类 https://gitee.com/battlebear/mydemo.git
 *
 *
 * 原文 https://felord.cn/generic-class.html
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class ParameterizedTypeDemo {
    public static void main(String[] args){
        test();
//        test1();
//        test2();
//        test3();

    }

    /**
     * 虽然泛型会在字节码编译过程中被擦除，但是，Class对象 会通过  java.lang.reflect.Type 接口
     * 记录其 "实现的接口" 或 "继承的父类" 信息。
     */
    static void test(){
        ArrayList<String> strings = new ArrayList<>();

        Class<? extends ArrayList> aClass = strings.getClass();
        Type genericSuperclass = aClass.getGenericSuperclass();


        System.out.println("genericSuperclass = " + genericSuperclass);
        // print:  genericInterfaces = java.util.AbstractList<E>
        // 可以看到 ArrayList 的 父类 AbstractList，以及父类的泛型标识。


        TypeVariable<? extends Class<? extends ArrayList>>[] typeParameters = aClass.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));
        // print:  [E]
        // 我们可能期望能够获得真实的泛型参数，但是仅仅获得了声明时泛型参数占位符。
        // getTypeParameters 方法的 Javadoc 也是这么解释的：仅返回声明时的泛型参数。
        // 所以，通过 getTypeParameters 方法无法获得运行时的泛型信息。
    }

    /**
     * Class.getGenericSuperclass() 获取到的具体类型
     *
     * 以下四个 接口/类 ，均 继承/实现 了Type接口：
     *
     *      ParameterizedType 用来描述  参数化类型
     *
     *      GenericArrayType  用来描述  一个参数泛型化的数组。
     *      WildcardType      用来描述  通配符? 相关的泛型，包含:  通配符 '?' 、下界通配符 '? super E' 、上界通配符 '? extend E'
     *      Class<T>          用来描述  类的Class对象。
     *
     */
    static void test1(){
        ArrayList<String> strings = new ArrayList<>();

        Type genericSuperclass = strings.getClass().getGenericSuperclass();

        System.out.println( genericSuperclass instanceof ParameterizedType); // true
        System.out.println( genericSuperclass instanceof Class); // false
        System.out.println( genericSuperclass instanceof WildcardType); // false
        System.out.println( genericSuperclass instanceof GenericArrayType); // false
    }


    /**
     * 由于 在实例化 ArrayList 时，只指定了 本身的泛型类型 而没有指定 父类AbstractList的具体泛型，所以获取到的就是 占位符 E。
     * 但是，这并不是我们想要的。我们希望能够获取 E 的 具体类型，也就是String。
     */
    static void test2(){
        ArrayList<String> strings = new ArrayList<>();

        // 1. 按照上面的思路，我们先获取 “继承的父类” 的信息。
        Type genericSuperclass = strings.getClass().getGenericSuperclass();

        // 2. 再根据 “接口” 或 “父类” 信息  获取 类型参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();


        // 打印参数类型
        System.out.println("actualTypeArguments = " + Arrays.toString(actualTypeArguments));
        // 打印结果：
        // actualTypeArguments = [E]
    }

    /**
     * 我们通过大括号{}实现一个匿名类，这个类是 SuperClass 的子类，
     * 这样，就可以实现 重写父类的方法 并 在实现的同时 指定父类的泛型具体类型 。
     */
    static void test3(){
        // 实现
        SuperClass<String> superClassInstance = new SuperClass<String>("试一试"){};

        Type genericSuperclass = superClassInstance.getClass().getGenericSuperclass();

        System.out.println(genericSuperclass); //SuperClass<java.lang.String>
    }

    /**
     * 我们可以借助这一特性来获取父类的具体泛型类型，我们按照这种思路，再次创建ArrayList来试试
     */
    static void test4(){
        ArrayList<String> strings = new ArrayList<String>(){};

        Type genericSuperclass = strings.getClass().getGenericSuperclass();


        System.out.println("genericSuperclass = " + genericSuperclass);
        // 打印结果：
        // genericSuperclass = java.util.ArrayList<java.lang.String>
    }

}

abstract class SuperClass<E> {
    private E e;

    protected SuperClass(E e) {
        this.e = e;
    }

    public E get() {
        return this.e;
    }
}