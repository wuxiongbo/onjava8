// functional/MethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface Callable {                          // [1]
    void call(String s);
}

class Describe {
    void show(String msg) {                   // [2]
        System.out.println(msg);
    }
}


/**
 * 绑定引用的情况下，函数式方法（接口中的单一方法）的签名 与 方法引用 的签名 要求完全匹配”
 *
 */
public class MethodReferences {
    static void hello(String name) {          // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {                 // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {        // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;                   // [6]
        c.call("call()");                    // [7]

        c = MethodReferences::hello;            // [8]
        c.call("Bob");

        c = new Description("valuable")::help;  // [9]
        c.call("information");

        c = Helper::assist;                     // [10]
        c.call("Help!");

//        Callable1 c1 = d::show;
    }
}

interface Callable1 {
    void call(Describe s);
}

/* Output:
call()
Hello, Bob
valuable information
Help!
*/
