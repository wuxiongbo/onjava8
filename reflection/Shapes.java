// reflection/Shapes.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;

/**
 * 基类中包含 draw() 方法，它通过传递 this 参数传递给 System.out.println()，间接地使用 toString() 打印类标识符。
 *
 * 注意：这里将 toString() 声明为 abstract，以此强制继承者覆盖该方法，并防止对 Shape 的实例化
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Stream.of(new Circle(), new Square(), new Triangle())
                .forEach(Shape::draw);

    }
}
/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*/
