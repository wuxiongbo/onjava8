// hiding/cookie2/Cookie.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package cookie2;

/**
 *
 * protected关键字 处理的是 "继承" 的概念
 *
 * protected：继承访问权限
 *
 */
public class Cookie {

    public Cookie() {
        System.out.println("Cookie constructor");
    }

    // protected 使得任何继承Cookie的类都可以访问 bite()
    protected void bite() {
        System.out.println("bite");
    }

}
