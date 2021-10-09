package mydemo;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> 获取父类的参数化类型  示例</p>
 *
 * 原文 https://felord.cn/generic-class.html
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/15
 * </pre>
 */
public class ParameterizedTypeDemo {
    public static void main(String[] args){
       test3();

    }

    /**
     * 虽然泛型会在字节码编译过程中被擦除，但是Class对象会通过java.lang.reflect.Type记录其 "实现的接口" 和 "继承的父类" 信息。
     */
    static void test(){
        ArrayList<String> strings = new ArrayList<>();

        Type genericSuperclass = strings.getClass().getGenericSuperclass();

        System.out.println("genericSuperclass = " + genericSuperclass); // genericInterfaces = java.util.AbstractList<E>
    }

    /**
     * Type的继承
     *
     * GenericArrayType  用来描述一个参数泛型化的数组。
     * WildcardType      用来描述通配符?相关的泛型，包含的?、下界通配符? super E 、上界通配符? extend E。
     * Class<T>          用来描述类的Class对象。
     * ParameterizedType 用来描述参数化类型
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
     * ArrayList实例化时，只指定了 自己的泛型类型 而没有指定 父类AbstractList的具体泛型，所以获取到的就是占位符E。
     */
    static void test2(){
        ArrayList<String> strings = new ArrayList<>();

        // 1. 按照上面的思路，我们先获取 “实现的接口” 或 “继承的父类” 的信息。
        Type genericSuperclass = strings.getClass().getGenericSuperclass();

        // 2. 再根据 “接口” 或 “父类” 信息  获取 类型参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        // 3. 打印参数类型
        System.out.println("actualTypeArguments = " + Arrays.toString(actualTypeArguments)); // [E]
    }

    /**
     * 我们通过大括号{} 实现匿名类，就可以重写实现父类的方法并 在实现的同时指定父类的泛型具体类型 。
     */
    static void test3(){
        // 实现
        SuperClass<String> superClassInstance = new SuperClass<String>("试一试"){};

        Type genericSuperclass = superClassInstance.getClass().getGenericSuperclass();

        System.out.println(genericSuperclass); //SuperClass<java.lang.String>
    }

    /**
     * 我们可以借助这一特性来获取父类的具体泛型类型，我们还拿ArrayList来试试
     */
    static void test4(){
        ArrayList<String> strings = new ArrayList<String>(){};

        Type genericSuperclass = strings.getClass().getGenericSuperclass();

        System.out.println("genericSuperclass = " + genericSuperclass); // genericSuperclass = java.util.ArrayList<java.lang.String>
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