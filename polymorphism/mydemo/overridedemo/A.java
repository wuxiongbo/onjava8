package mydemo.overridedemo;

/**
 * @author Xander Wu
 * @date 2022/10/13 21:11
 */
public class A {

    // 模板方法
    public void fun1(){
        System.out.println("A.fun1()");
        fun2();
    }


    // 模板
    public void fun2(){
        System.out.println("A.fun2()");
    }

}
