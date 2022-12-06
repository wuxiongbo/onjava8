// generics/ApplyFunctional.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * 上接 generics/ApplyTest.java
 *
 * 潜在类型机制
 * Java8 中使用流和函数工具 辅助(注意，是 辅助 不是 实现) "潜在类型"，同时，具备 “编译期类型检查”
 *
 * 使用 FilledList 和 shapeQ 调用 forEach() 比 Apply.apply() 代码整洁得多。
 *
 * 在代码 ‘简单性’ 和 ‘可读性’ 方面，结果 比 以前的方法 好得多。并且，现在也不可能从 main() 引发异常。
 *
 * 更多示例：
 * generics/mydemo1/LatentReflection1.java
 *
 *
 */
public class ApplyFunctional {

    public static void main(String[] args) {

        // 我们首先生成两个 Stream ：
        //      一个是 父类Shape ，一个是 子类Square ，并将它们展平为单个流。
        Stream.of(
                    Stream.generate(Shape::new).limit(2),
                    Stream.generate(Square::new).limit(2)
                )
                // 尽管 Java 缺少函数式语言中经常出现的 flatten() 扁平化 ，但是我们可以使用 flatMap(c->c) 起到相同的作用，
                // 后者使用 身份映射，将操作简化为 “ flatten ”。
                .flatMap(c -> c) // 扁平化为一个流

                // 然后，我们用 peek() 对 rotate()方法进行调用。 因为 peek() 会执行调用操作（此处是出于副作用），并在不更改原始对象的情况下传递对象。
                .peek(Shape::rotate) // 消费方法

                //  遍历集合，并调用元素的方法。
                .forEach(s -> s.resize(7));




        // 往集合填充 Shape元素。个数为 2
        new FilledList<>(Shape::new, 2)
                // 遍历集合，并调用元素的方法。
                .forEach(Shape::rotate);

        // 往集合填充 Square元素。个数为 2
        new FilledList<>(Square::new, 2)
                // 遍历集合，并调用元素的方法。
                .forEach(Shape::rotate);



        // 往集合填充 Shape元素。个数为 2
        SimpleQueue<Shape> shapeQ = Suppliers.fill(new SimpleQueue<>(), SimpleQueue::add, Shape::new, 2);
        // 继续往集合填充 Shape元素。个数为 2
        Suppliers.fill(shapeQ, SimpleQueue::add, Square::new, 2);

        // 遍历集合，并调用元素的方法。
        shapeQ.forEach(Shape::rotate);






        // Suppliers.fill()  的实现不太好理解，我写成下面这种方式，更加便于理解。

        SimpleQueue<Shape> holder = new SimpleQueue<>();


        // 下面这段代码是 BiConsumer匿名内部类  效果等价于  SimpleQueue::add
        BiConsumer<SimpleQueue<Shape>, Shape> adder = new BiConsumer<SimpleQueue<Shape>, Shape>(){
            @Override
            public void accept(SimpleQueue<Shape> simpleQueue, Shape shape) {
                simpleQueue.add(shape);
            }
        };

        // 下面这段代码是 Supplier匿名内部类  效果等价于  Square::new
        Supplier<Shape> generator = new Supplier<Shape>(){
            @Override
            public Shape get() {
                return new Shape();
            }
        };


        Suppliers.fill(holder, adder, generator , 2);
        holder.forEach(Shape::rotate);

    }

}
/* Output:
Shape 0 rotate
Shape 0 resize 7
Shape 1 rotate
Shape 1 resize 7
Square 2 rotate
Square 2 resize 7
Square 3 rotate
Square 3 resize 7
Shape 4 rotate
Shape 5 rotate
Square 6 rotate
Square 7 rotate
Shape 8 rotate
Shape 9 rotate
Square 10 rotate
Square 11 rotate
*/
