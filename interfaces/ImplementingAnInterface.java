// interfaces/ImplementingAnInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Concept { // Package access
    void idea1();

    void idea2();
}

class Implementation implements Concept {
    /**
     * 来自接口的方法必须被定义为public。
     * 否则，它们将默认为包访问权限，导致在继承期间降低了方法的可访问性，而这是Java编译器不允许的
     */
    @Override
    public void idea1() {
        System.out.println("idea1");
    }

    @Override
    public void idea2() {
        System.out.println("idea2");
    }
}
