// generics/UnboundedWildcards1.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 无界通配符 <?>
 *
 * 参数列表: new ArrayList();  new ArrayList<>();  List<?>;
 *
 * assign1:
 *   List                     List
 *   List<?>                  List
 *   List<? extends Object>   List    // warning
 *
 * assign2:
 *   List                     List<?>
 *   List<?>                  List<?>
 *   List<? extends Object>   List<?>
 *
 * assign3:
 *   List                     List<List<? extends Object>
 *   List<?>                  List<List<? extends Object>
 *   List<? extends Object>   List<List<? extends Object>
 *
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        list3 = list; // warning
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


    // 有很多情况都和你在这里看到的情况类似，即 编译器很少关心使用的是  原生类型 还是 <?> 。
    // 在这些情况中， <?> 可以被认为是一种装饰，但是它 ‘仍旧是很有价值的’
    // 因为，实际上它是在声明：
    //     “我是想用 Java 的泛型来编写这段代码，我在这里并不是要用原生类型，
    //      但是，在当前这种情况下，泛型参数可以持有任何类型。”
    public static void main(String[] args) {
        //===== List=====
        assign1(new ArrayList());
        assign2(new ArrayList());
        assign3(new ArrayList()); // warning


        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        // 这两种形式都可以作为List<?>接受。
        List<?> wildList = new ArrayList();
//        wildList = new ArrayList<>();

        //====== List<?> ======
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);


        List a = new ArrayList();// 使用原生类型  List 意味着放弃编译检查
        List<?> b = new ArrayList();
        List<? extends Object> c = new ArrayList();  // warning
        // 可以发现，编译器处理 List<?> 和 List<? extends Object> 是不同的。


        // 令人困惑的是，编译器并非总是关注像 List 和 List<?> 之间的这种差异，因此它们看起来就像是相同的事物。


        // 因为泛型参数擦除到它的第一个边界，因此 List<?> 看起来等价于List<Object> ，而 List 实际上也确实是 List<Object> 。
        // 实际上  List 表示        “持有任何 Object 类型的原生 List”,
        // 而     List<?> 表示     “具有某种特定类型的非原生 List ，只是我们不知道类型是什么。”


        List a2 = new ArrayList<>();
        List<?> b2 = new ArrayList<>();
        List<? extends Object> c2 = new ArrayList<>();

        // 编译器何时才会关注 原生类型 和 涉及无界通配符的类型 之间的差异呢？
        // generics/Wildcards.java
    }




    private void test(){

        // (-∞, 上界(MyClass)]，[下界(MyClass)， Object]

        // 1) 边界。 用于读
        List<? extends Apple> c3 = new ArrayList<>(Collections.singletonList(new Apple()));
        // 不可写入-边界类型
//        c3.add(new Apple());
        // 不可写入-Object
//        c3.add(new Object());
        // 可读取-边界类型
        Apple apple2 = c3.get(0);
        // 可读取-Object
        Object object = c3.get(0);

        // 2) 逆变。 用于写
        List<? super Apple> c4 = new ArrayList<>(Collections.singletonList(new Fruit())); // 苹果 的 某种父类型
        // 可写入-边界类型。
        c4.add(new Apple());
        // 不可写入-父类型。
//        c4.add(new Fruit());
        // 只可读取-Object
        Object obj = c4.get(0);  // List<? super Apple>  只能返回  Object
        Apple apple3 = (Apple)c4.get(0);  // 除非，你已经知道更多信息，然后强转

    }

}
