// polymorphism/PrivateOverride2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Detecting a mistaken override using @Override
// {WillNotCompile}

public class PrivateOverride2 {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride2 po = new Derived2();
        po.f();
    }
}

class Derived2 extends PrivateOverride2 {
    //使用@Override来检测意外重写
//    @Override
    public void f() {
        System.out.println("public f()");
    }
}
