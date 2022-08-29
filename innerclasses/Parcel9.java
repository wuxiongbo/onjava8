// innerclasses/Parcel9.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 *
 * 匿名内部类‘成员变量’使用的 参数引用最好是 final 修饰
 *
 *
 *  innerclasses/AnonymousConstructor.java
 *
 */
public class Parcel9 {
    // Argument must be final or "effectively final"
    // to use within the anonymous inner class:
    public Destination destination(final String dest) {  // 建议 final 修饰。这里不写final也没有任何问题，但把它写上，当作提醒通常更好。

        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
}
