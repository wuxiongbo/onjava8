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


        // 使用原生类型  List 意味着放弃编译检查
        List a = new ArrayList();

        // 编译器处理 List<?> 和 List<? extends Object> 是不同的。
        List<?> b = new ArrayList();
        List<? extends Object> c = new ArrayList();  // warning



        // 因为泛型参数擦除到它的第一个边界，因此 List<?> 看起来等价于List<Object> ，而 List 实际上也是 List<Object> 。
        // 实际上  List 表示        “持有任何 Object 类型的原生 List”,
        // 而     List<?> 表示     “具有某种特定类型的非原生 List ，只是我们不知道类型是什么。”


        List a2 = new ArrayList<>();
        List<?> b2 = new ArrayList<>();
        List<? extends Object> c2 = new ArrayList<>();

    }


    private void test(){

        // (-∞, 上界(MyClass)]，[下界(MyClass)， Object]

        // 边界。 可读 上界类型。  不可写
        List<? extends Apple> c3 =new ArrayList<>();
//        c3.add(new Apple());
//        c3.add(new Object());
        c3.add(null);
        Apple apple2 = c3.get(0);


        // 逆变。 可写 下界类型。 只可读 Object
        List<? super Apple> cc = new ArrayList<Fruit>();

        List<? super Apple> c4 =new ArrayList<>();
        c4.add(new Apple());


        // Apple 是下界，所以，向这样的 List 中添加 Fruit 是不安全的。
        // 因为，这将使这个 List 敞开口子，从而，可以向其中添加 非Apple类型的对象(如，同样继承自Fruit的Orange)，而这是违反静态类型安全的。
        // c4.add(new Fruit());


        // List<? super Apple>  只能返回  Object
        Object obj = c4.get(0);

        // 除非，知道更多信息。（知道具体类型的前提下，进行强转）
        Apple apple3 = (Apple)c4.get(0);
    }

}
