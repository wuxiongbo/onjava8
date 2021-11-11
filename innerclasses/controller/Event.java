// innerclasses/controller/Event.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The common methods for any control event
package controller;

import java.time.*; // Java 8 time classes

/**
 *
 * 这是一个抽象的事件
 *
 * 为什么使用抽象类，而不是接口？
 * 首先，接口 可以描述要控制的事件。 但因为其默认的行为是基于时间去执行控制，这个逻辑是固定的，所以使用抽象类代替实际的接口，以保持部分实现。
 *
 * 保留 固定事物，开放 变化事物。
 *
 *
 * 这是设计模式中 “模板方法” 的一个典型，模板方法 包含算法的基本结构，并且会调用 一个 或 多个 可覆盖的方法，以完成算法的动作。
 * 设计模式总是将 变化的事物 与 保持不变的事物 分离开来，
 * 在 “模板方法模式” 中，模板方法 是 保持不变的事物，而 可覆盖的方法 就是 变化的事物。
 *
 */
public abstract class Event {
    private Instant eventTime;           // 事件 “就绪” 的时刻
    protected final Duration delayTime;  // 准备时长

    // 因为事件 ‘默认的行为’ 是基于时间去执行控制，这部分 ‘默认的行为’ 可以抽象出来，所以使用的 “抽象类” 而不是 “接口”。
    protected Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start(); // 构造事件的时候，写入一次 “就绪” 时刻
    }

    /**
     * 记录“就绪”时刻。
     * 每次重启，都重新记录 一次最新的 “就绪” 时刻
     */
    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }

    /**
     * 判断 是否“就绪”
     * @return
     */
    protected boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    /**
     * 控制算法
     *
     * 控制框架并不包含任何 具体的信息。
     * 那些信息，是由 继承类 的action()方法 实现的算法 来提供的。
     */
    public abstract void action();
}
