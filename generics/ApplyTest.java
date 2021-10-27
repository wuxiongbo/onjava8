// generics/ApplyTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.function.*;

/**
 * 接 generics/Apply.java
 *
 * 测试：将 任何方法 应用于 序列 中的所有对象
 *
 * 在 Apply 中，我们运气很好，因为碰巧在 Java 中内建了一个由 Java 集合类库使用的 Iterable 接口。
 * 正由于此，apply() 方法可以接受任何实现了 Iterable 接口的事物，包括诸如 List 这样的所有 Collection 类。
 * 但是它还可以接受其他任何事物，只要能够使这些事物是 Iterable 的
 *
 * 正如 反射解决方案 看起来那样优雅，我们必须观察到反射（尽管在 Java 的最新版本中得到了显着改进）通常比非反射实现要慢，
 * 因为，在 “运行时” 发生了很多事情。但 这个问题 不应阻止您尝试这种解决方案，不过，这依然是一个值得考虑的问题点。
 *
 *
 * 个人总结，使用反射的方式 实现 对 ‘潜在类型机制’ 的“补偿”，存在以下问题：
 *      1. 将 “编译期类型检查” 转移到了 “运行时”
 *      2. 反射 比 非反射 要慢
 *
 * 我们可以利用 Java 8 的流和函数工具，对 ApplyTest.java 进行重写，解决上述的两个问题：
 * generics/ApplyFunctional.java
 *
 * 更多示例：
 * generics/mydemo/LatentReflection1.java
 */
public class ApplyTest {
    public static void main(String[] args) throws Exception {

        // 调用 List<Shape> 集合中 持有的对象 Shape  的  rotate、resize 方法
        List<Shape> shapes = Suppliers.create(ArrayList::new, Shape::new, 3);
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 7);


        // 调用 List<Square> 集合中 持有的对象 Square  的  rotate、resize 方法
        List<Square> squares = Suppliers.create(ArrayList::new, Square::new, 3);
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 7);



        Apply.apply(new FilledList<>(Shape::new, 3), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<>(Square::new, 3), Shape.class.getMethod("rotate"));



        SimpleQueue<Shape> shapeQ = Suppliers.fill(new SimpleQueue<>(), SimpleQueue::add, Shape::new, 3);
        Suppliers.fill(shapeQ, SimpleQueue::add, Square::new, 3);

        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));


    }
}
/* Output:
Shape 0 rotate
Shape 1 rotate
Shape 2 rotate
Shape 0 resize 7
Shape 1 resize 7
Shape 2 resize 7
Square 3 rotate
Square 4 rotate
Square 5 rotate
Square 3 resize 7
Square 4 resize 7
Square 5 resize 7
Shape 6 rotate
Shape 7 rotate
Shape 8 rotate
Square 9 rotate
Square 10 rotate
Square 11 rotate
Shape 12 rotate
Shape 13 rotate
Shape 14 rotate
Square 15 rotate
Square 16 rotate
Square 17 rotate
*/
