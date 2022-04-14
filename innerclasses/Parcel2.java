// innerclasses/Parcel2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Returning a reference to an inner class

public class Parcel2 {

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    // 更普遍的情况是：
    // 外部类 有一种方法函数，该 方法 返回一个指向内部类的引用
    // 正如在 to() 和 contents() 方法中看到的那样：
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }


    public void ship(String dest) {

//        Contents c = new Contents();
//        Destination d = new Destination(dest);

        Contents c = contents();
        Destination d = to(dest);

        System.out.println(d.readLabel());

    }



    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");

        Parcel2 q = new Parcel2();
        // Defining references to inner classes:
        // 具体地指明这个对象的类型：OuterClassName.InnerClassName
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");

    }

}
/* Output:
Tasmania
*/
