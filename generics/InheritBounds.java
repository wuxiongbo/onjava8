// generics/InheritBounds.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 冗余代码抽取出来，通过继承来消除冗余
class HoldItem<T> {
    T item;
    HoldItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}





//  Solid2 继承 WithColorCoord2 继承 WithColor2 继承 HoldItem 。
//  每个继承级别还添加了边界约束
class WithColor2<T extends HasColor> extends HoldItem<T> {
    WithColor2(T item) {
        super(item);
    }

    // 添加 HasColor  颜色
    java.awt.Color color() {
        return item.getColor();
    }
}
class WithColorCoord2<T extends Coord & HasColor> extends WithColor2<T> {
    WithColorCoord2(T item) {
        super(item);
    }

    // 添加 Coord  坐标
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
class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoord2<T> {
    Solid2(T item) {
        super(item);
    }

    // 添加 Weight  宽度
    int weight() {
        return item.weight();
    }
}


/**
 * 接 BasicBounds
 *
 * 边界
 * 消除冗余代码，优化版
 *
 */
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
