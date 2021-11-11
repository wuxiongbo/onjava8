// innerclasses/TestParcel.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Parcel4 {

    /**
     * private 内部类给类的设计者提供了一种方式，通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。（即，面向接口编程）
     */
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }

        // 由于，不能访问任何 新增加的、原本不属于公共接口的方法，
        // 所以，扩展接口方法是没有意义的
        public void f1(){
        }

    }

    /**
     * PDestination 是 protected，所以只有 Parcel4 及 其子类、还有与 Parcel4 同 一个包中的类（因为 protected 也给予了包访问权）能访问 PDestination，
     * 其他类都不能访问 PDestination，
     *
     * 这意味着，如果客户端程序员想了解或访问这些成员，那是要受到限制的。
     */
    protected final class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        // Illegal -- can't access private class:
        //- Parcel4.PContents pc = p.new PContents();
    }
}
