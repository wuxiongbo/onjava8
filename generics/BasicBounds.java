// generics/BasicBounds.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 坐标
class Coord {
    public int x, y, z;
}
// 颜色
interface HasColor {
    java.awt.Color getColor();
}
// 宽度
interface Weight {
    int weight();
}


// 一个边界
class WithColor<T extends HasColor> {
    // 冗余
    T item;
    WithColor(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    // The bound allows you to call a method:
    // 这个约束允许你调用一个方法。
    java.awt.Color color() {
        return item.getColor();
    }
}

// 这样写，编译会报错。因为 类 必须在首位, 然后才能是 接口:
// class WithColorCoord<T extends HasColor & Coord> {}
// 二个边界
class WithColorCoord<T extends Coord & HasColor> {
    // 冗余
    T item;
    WithColorCoord(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    // 这个约束允许你调用以下方法。
    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

// 多个边界
// 和继承一样，你只能继承一个具体类，但可以继承多个接口:
class Solid<T extends Coord & HasColor & Weight> {
    // 冗余
    T item;
    Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }

    // 这个约束允许你调用以下方法。

    // HasColor  颜色
    java.awt.Color color() {
        return item.getColor();
    }

    // Coord  坐标
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }

    // Weight  宽度
    int weight() {
        return item.weight();
    }
}

// 创建Bounded类， 以 满足 约束<T extends Coord & HasColor & Weight>
class Bounded extends Coord implements HasColor, Weight {
    @Override
    public java.awt.Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

/**
 * 边界
 * 示例
 *
 */
public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid =  new Solid<>(new Bounded());
        solid.color();
        solid.getX();
        solid.weight();
    }

}
