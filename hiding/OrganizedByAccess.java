// hiding/OrganizedByAccess.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 出于两个重要的原因，访问权限控制在数据类型的内部设置了访问边界:
 *
 * 第一个原因：
 *      确定 客户程序员 可以使用和不可以使用的内容。
 *      你在这个结构里创建自己的内部机制，而不必担心 客户程序员 会不小心将这个内部机制视为他们可以使用的接口的一部分。
 *
 * 这直接引出了第二个原因：
 *      将接口与实现分离。
 *      如果在一组程序里使用了该结构，客户程序员  除了 将消息发送到 public接口 之外  什么都不能做，
 *      这样，你就可以自由地更改任何非public的代码（例如包访问权限、protected或private），而不会破坏客户端代码。
 *
 *
 * 下面这样做仅仅使得代码阅读起来稍微容易一些，因为接口和实现仍然混合在一起。也就是说，你仍然可以看到源代码（即实现），因为它就在类中。
 *
 */
public class OrganizedByAccess {


    // 访问权限控制：
    // 1. 避免 客户程序员 不小心使用到 内部机制 (如：priv1、priv2等)
    // 2. 接口 与 实现分离。 修改实现而不破坏客户端代码。
    public void pub1() { /* ... */ }

    public void pub2() { /* ... */ }

    public void pub3() { /* ... */ }



    private void priv1() { /* ... */ }

    private void priv2() { /* ... */ }

    private void priv3() { /* ... */ }

    private int i;
    // ...


}
