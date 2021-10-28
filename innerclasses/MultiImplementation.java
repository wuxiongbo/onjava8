// innerclasses/MultiImplementation.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// For concrete or abstract classes, inner classes
// produce "multiple implementation inheritance"
// {java innerclasses.MultiImplementation}

/**
 * 如果拥有的是 “抽象的类” 或 “具体的类” 而不是 “接口”，那就只能使用 内部类 才能实现 类似“多重继承” 的效果
 */
class D {
}
abstract class E {
}

// Z 想实现 “多重继承”，只能通过内部类的方式
class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
