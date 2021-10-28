// innerclasses/TestBed.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Putting test code in a nested class
// {java TestBed$Tester}

/**
 * 嵌套类
 *
 * 在每个类中都写一个 main() 方法，用来测试这个类。这样做有一个缺点，那就是必须带着那些已编译过的额外代码。
 *
 * 如果这对你是个麻烦，那就可以使用嵌套类来放置测试代码。
 *
 * 这生成了一个独立的类 TestBed$Tester(要运行这个程序, 执行 java TestBed$Tester，在 Unix/Linux 系统中需要转义).
 * 你可以使用这个测试类, 但是不必在发布的产品中包含它, 可以在打包产品前 删除 TestBed$Tester.class
 *
 */
public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
/* Output:
f()
*/
