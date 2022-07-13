// reuse/SpaceShipDelegation.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 委托
 *
 * '方法调用' 被 "转发" 到了  内部的controls对象，因此 这里得到的接口 与 使用继承得到的 是相同的。
 * 但是，这里可以更好地控制 委托 ，因为你可以选择 仅提供 成员对象中的 部分方法。
 *
 * 尽管Java语言不支持 委托，但开发工具通常支持。例如，上面的示例就是用JetBrains Idea集成开发工具自动生成的。
 *
 *
 * 组合与继承:
 * reuse/PlaceSetting.java
 */
public class SpaceShipDelegation {
    private String name;

    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    // Delegated methods:
    public void back(int velocity) {
        controls.back(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
}
