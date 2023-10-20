// exceptions/Rethrowing.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrating fillInStackTrace()

/**
 * @see RethrowNew
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("f()方法，入栈---333");

        System.out.println("=======完成调用栈中最内层的调用逻辑========");

//        System.out.println("originating the exception in f()");
        System.out.println("f()方法抛出一个原始异常，出栈：---333");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        System.out.println("g()方法，入栈---222");

        try {
            f();
        } catch (Exception e) {

//            System.out.println("Inside g(), e.printStackTrace()");
            System.out.println("g()方法中，通过异常获取栈信息: ---222");
            e.printStackTrace(System.out);

            System.out.println("g()方法，传递异常，出栈---222");
            throw e;
        }
    }

    public static void h() throws Exception {
        System.out.println("h()方法，入栈---222");

        try {
            f();
        } catch (Exception e) {
//            System.out.println("Inside h(), e.printStackTrace()");
            System.out.println("h()方法中，打印方法栈信息:");
            e.printStackTrace(System.out);

            System.out.println("h()方法，重新填充栈跟踪，出栈，打印方法栈信息:---222");
            throw (Exception) e.fillInStackTrace();  // 调用 fillInStackTrace()的那一行，成了这个异常的新起点
        }
    }

    public static void main(String[] args) {
        System.out.println("main()方法，入栈---111");

        // main->g->f
        try {
            g();
        } catch (Exception e) {
//            System.out.println("main: printStackTrace()");
            System.out.println("main()方法中，打印方法栈信息:");
            e.printStackTrace(System.out);
        }

        System.out.println("---上面为示例1---示例分割线----下面为示例2----");


        // main->h->f
        // h() 将异常的堆栈信息重新填充后，只知道异常是来自内部的try块，而不知道它来自 f()”
        try {
            h();
        } catch (Exception e) {
//            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        System.out.println("main()方法，出栈---111");

    }

}
/* Output:
originating the exception in f()
Inside g(), e.printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:8)
        at Rethrowing.g(Rethrowing.java:12)
        at Rethrowing.main(Rethrowing.java:32)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:8)
        at Rethrowing.g(Rethrowing.java:12)
        at Rethrowing.main(Rethrowing.java:32)
originating the exception in f()
Inside h(), e.printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.f(Rethrowing.java:8)
        at Rethrowing.h(Rethrowing.java:22)
        at Rethrowing.main(Rethrowing.java:38)
main: printStackTrace()
java.lang.Exception: thrown from f()
        at Rethrowing.h(Rethrowing.java:27)
        at Rethrowing.main(Rethrowing.java:38)
*/
