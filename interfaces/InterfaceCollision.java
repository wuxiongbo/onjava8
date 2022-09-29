// interfaces/InterfaceCollision.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 重写、实现和重载令人不快地混合在一起
// 将接口组合在一起时，在不同接口中 使用相同的方法名称 ，通常会导致代码可读性较差。
// 应该努力避免这种情况。
interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

/**
 * 方法签名 不同 ， 返回类型 不同
 */
class C2 implements I1, I2 {
    /**
     * 方法实现
     */
    @Override
    public void f() {
    }

    /**
     * 方法实现
     * 方法重载
     * @param i
     * @return
     */
    @Override
    public int f(int i) {
        return 1;
    } // Overloaded
}

// 方法签名 不同，返回类型 相同
class C3 extends C implements I2 {
    /**
     * 方法重写
     * 方法实现
     * @param i
     * @return
     */
    @Override
    public int f(int i) {
        return 1;
    } // Overloaded
}

// 方法签名 相同，返回类型 相同
class C4 extends C implements I3 {
    // 方法实现
    // 方法重写
    // C.f() 与 I3.f() 方法签名完全相同，没有问题
    @Override
    public int f() {
        return 1;
    }
}

// 方法签名相同，返回类型 不同

// I1.f()没有返回值，C.f()有返回值
//class C5 extends C implements I1 {}

// I1.f()没有返回值，I3.f()有返回值
//interface I4 extends I1, I3 {}
