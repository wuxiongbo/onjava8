// hiding/dessert/Cookie.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creates a library
package dessert;

/**
 * 当你使用关键字 public，就意味着，紧随public后 声明的成员 对于 每个人 都是可用的，尤其是使用类库的 “客户端程序员” 。
 *
 * 假设你定义了一个包含以下编译单元的dessert包:
 * Cookie.java 文件产生的类文件必须位于名为 dessert 的子目录中，该子目录在 hiding目录下，
 * 而hiding目录必须位于CLASSPATH指定的路径之一里。
 * 不要错误地认为: Java 会始终将当前目录视为搜索的起点之一。
 * CLASSPATH中没有指定“.”作为路径之一，Java就不会在当前目录里查找。
 *
 *
 * hiding/Dinner.java
 *
 */
public class Cookie {

    public Cookie() {
        System.out.println("Cookie constructor");
    }

    //  默认的  "包访问权限"
    void bite() {
        System.out.println("bite");
    }

}
