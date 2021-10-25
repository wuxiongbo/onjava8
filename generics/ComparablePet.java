// generics/ComparablePet.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 假设，你有一个实现了 Comparable 接口的 Pet 类。   Pet 宠物
public class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}
