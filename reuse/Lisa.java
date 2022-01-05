// reuse/Lisa.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

// 子类 隐藏了 基类的方法名称
class Lisa extends Homer {

    // 当你打算重写一个方法时，可以选择添加@Override注解，
    // 如果不小心对方法进行了 重载 而不是 重写，编译器就会产生一个错误消息，这样，@Override注解 就防止了意外重载。
//    @Override
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }

}
