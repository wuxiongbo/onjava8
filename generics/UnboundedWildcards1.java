// generics/UnboundedWildcards1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 无界通配符 <?>
 *
 * arg: new ArrayList()
 *      new ArrayList<>()
 *
 * assign1: List
 *   List
 *   List<?>
 *   List<? extends Object>
 *
 * assign2: List<?>
 *   List
 *   List<?>
 *   List<? extends Object>
 *
 * assign3: List<List<? extends Object>
 *   List
 *   List<?>
 *   List<? extends Object>
 *
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;

        list3 = list;

        // warning: [unchecked] unchecked conversion
        // list3 = list;
        //         ^
        // required: List<? extends Object>
        // found:    List
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }




    // 编译器很少关心使用的是原生类型还是 <?> 。
    // 在这些情况中，<?> 可以被认为是一种装饰，但是它仍旧是很有价值的
    // 因为，实际上它是在声明：
    //      “我是想用 Java 的泛型来编写这段代码，我在这里并不是要用原生类型，但是在当前这种情况下，泛型参数可以持有任何类型。”
    public static void main(String[] args) {

        assign1(new ArrayList());
        assign2(new ArrayList());

        // assign3(new ArrayList());

        // warning: [unchecked] unchecked method invocation:
        //    method assign3 in class UnboundedWildcards1 is applied to given types
        // assign3(new ArrayList());
        //        ^
        // required: List<? extends Object>
        // found: ArrayList

        // warning: [unchecked] unchecked conversion
        // assign3(new ArrayList());
        //         ^
        // required: List<? extends Object>
        // found:    ArrayList

        // 2 warnings

        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        // 这两种形式都可以作为List<?>接受
        // Both forms are acceptable as List<?>:
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();

        assign1(wildList);
        assign2(wildList);
        assign3(wildList);



        // 使用原生类型 意味着放弃编译检查
        List a = new ArrayList();
        List<?> b = new ArrayList();
        List<? extends Object> c = new ArrayList();

        List a2 = new ArrayList<>();
        List<?> b2 = new ArrayList<>();
        List<? extends Object> c2 = new ArrayList<>();



        // (-∞, 上界]，[下界， Object]

        // 边界。 可读 上界类型。  不可写
        List<? extends Apple> c3 =new ArrayList<>();
//        c3.add(new Apple());
//        c3.add(new Object());
        c3.add(null);
        Apple apple2 = c3.get(0);


        // 逆变。 只可读 Object。 可写 下界类型
        List<? super Apple> cc = new ArrayList<Fruit>();

        List<? super Apple> c4 =new ArrayList<>();
        c4.add(new Apple());

        // Apple 是下界，所以向这样的 List 中添加 Fruit 是不安全的，因为这将使这个 List 敞开口子，
        // 从而可以向其中添加 非Apple类型的对象(如，同样继承自Fruit的Orange)，而这是违反静态类型安全的。
        // c4.add(new Fruit());

        // 只能返回Object
        Object obj = c4.get(0);

        // 除非知道更多信息。
        Apple apple3 = (Apple)c4.get(0);


    }




}
