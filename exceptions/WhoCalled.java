// exceptions/WhoCalled.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Programmatic access to stack trace information

public class WhoCalled {
    static void f() {
        // 生成一个异常来填充栈轨迹
        try {
            throw new Exception();
        } catch (Exception e) {
            // 完整的栈信息
            StackTraceElement[] stackTrace = e.getStackTrace();

            // 遍历方法栈
            int i = 0;
            for (StackTraceElement ste : stackTrace) {
                System.out.println("栈深度: " + i++);
                System.out.println("方法名: " + ste.getMethodName() );
                System.out.println("类名: " + ste.getClassName() );
                System.out.println("文件名: " + ste.getFileName() );
                System.out.println("行号: " + ste.getLineNumber() );
                // since 9+
//                System.out.println("类加载器名称: " + ste.getClassLoaderName() );
//                System.out.println("模块名: " + ste.getModuleName() );
//                System.out.println("模块版本: " + ste.getModuleVersion() );

                System.out.println("全部信息: " + ste);
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {

        // main -> f
        System.out.println("*******示例1*******");
        f();

        // main -> g -> f
        System.out.println("*******示例2*******");
        g();

        // main -> h -> g -> f
        System.out.println("*******示例3*******");
        h();
    }
}
/* Output:
f
main
*******
f
g
main
*******
f
g
h
main
*/
