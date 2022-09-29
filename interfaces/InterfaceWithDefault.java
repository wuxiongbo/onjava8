// interfaces/InterfaceWithDefault.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

interface InterfaceWithDefault {
    void firstMethod();

    void secondMethod();

  /**
   *
   * 如果使用default关键字来为newMethod()提供默认定义，则使用该接口的所有旧代码都可以继续工作。
   * 否则，会强制要求子类实现新增方法。
   *
   * 结论：
   * 添加默认方法的一个令人信服的原因是，它允许向现有接口中添加方法，而不会破坏已经在使用该接口的所有代码。
   * 默认方法有时也称为防御方法（defender method）或虚拟扩展方法（virtual extension method）。
   * 在JDK 9中，接口里的 default 和 static 方法都可以是private的。
   */
  default void newMethod() {
        System.out.println("newMethod");
    }
}
