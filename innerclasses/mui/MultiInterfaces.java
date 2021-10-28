// innerclasses/mui/MultiInterfaces.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Two ways a class can implement multiple interfaces
// {java innerclasses.mui.MultiInterfaces}
package mui;


interface A {
}
interface B {
}

// 方式一： 一个类实现两个接口
class X implements A, B {
}
// 方式二： 类实现一个接口，内部类实现另一个接口
class Y implements A {
    B makeB() {
        // Anonymous inner class:
        return new B() {
        };
    }
}


public class MultiInterfaces {
    static void takesA(A a) {
    }

    static void takesB(B b) {
    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);

        takesB(x);
        takesB(y.makeB());
    }
}
