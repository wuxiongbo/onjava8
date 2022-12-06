// reuse/DerivedSpaceShip.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 太空船
 * DerivedSpaceShip 并非真正的 SpaceShipControls类型，即使你可以“告诉”一个DerivedSpaceShip  调用forward()方法。
 * 更准确地说，一艘太空船中包含了 SpaceShipControls，同时 SpaceShipControls中的所有方法 也都在 太空船中暴露给了外部。
 *
 *
 * 委托解决了以下难题
 * reuse/SpaceShipDelegation.java
 *
 */
public class DerivedSpaceShip extends SpaceShipControls {
    private String name;

    public DerivedSpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        DerivedSpaceShip protector =
                new DerivedSpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
