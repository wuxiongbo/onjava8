// generics/ComparablePet.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 泛型存在的问题5：基类劫持接口
 *
 * 假设，你有一个实现了 Comparable 接口的 Pet 类。   Pet 宠物
 *
 * 下接 generics/HijackedInterface.java
 */
public class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}
