// generics/NonCovariantGenerics.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.ArrayList;
import java.util.List;

/**
 * generics/CovariantArrays.java
 *
 * 通配符？
 *
 * 通过下面的示例，我们发现一个现象：
 *    泛型数组 可以向上转型，而 泛型List 不能向上转型。
 *
 * 这是为什么呢？
 *
 *
 * 我们知道，不仅仅是集合才涉及到泛型，所以，下面这段代码 真正要表达的是 —— 不能把  "一个涉及 Apple 的泛型"  赋值给  "一个涉及 Fruit 的泛型"
 *
 * 编译器告诉我们， “Apple 的 List”  在类型上  不等价于 “Fruit 的 List” 。  即使，Apple 是一种 Fruit 类型
 *
 * 真正的问题是，我们在讨论的 “集合类型”，  而不是 “集合持有对象的类型” 。
 * 集合 与 数组 不同，泛型没有内建的 “协变类型” 。
 *
 * 这是因为，数组是完全在语言中定义的，因此可以具有 “编译期” 和 “运行时” 的 内建检查，
 * 但是，在使用泛型时，“编译器” 和 “运行时系统” 不知道你想用类型做什么，以及应该采用什么规则。
 *
 * 然而，有时，你想在两个类型间建立某种 向上转型 关系。
 *
 * 那么此时，“通配符” 就派上用场了，它可以用来产生这种关系。
 *
 * generics/GenericsAndCovariance.java
 *
 */
public class NonCovariantGenerics {

    // 编译报错：不兼容的类型
//    List<Fruit> flist = new ArrayList<Apple>();



    private static List<Fruit> getFruit(List<Fruit> fruit){
        return fruit;
    }

    // 运行报错：类型转换异常
    public static void main(String[] args){

        List raw = new ArrayList();
        raw.add(new Object());
        raw.add("12321321");
        raw.add(new Apple());
        raw.add(new Fruit());


        // 使用原生类，意味着 放弃编译检查。
        List<Fruit> fruitList = raw;



        // getFruit() 放弃了编译检查，然后，就可以 开始欺骗 编译器了。
        // 导致的结果是， “Apple 的 List”  接受了  “Fruit 的 List”
        List<Apple> appleList = getFruit(raw);


        // 编译器以为我们存的是Apple。 骗过了编译期
        // 但是，在运行期，发现转型出问题了
        Apple apple = appleList.get(0);

    }

}

/*
  输出：
  Exception in thread "main" java.lang.ClassCastException: java.lang.Object cannot be cast to Apple
 */