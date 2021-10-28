// innerclasses/controller/Event.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The common methods for any control event
package controller;

import java.time.*; // Java 8 time classes

public abstract class Event {
    private Instant eventTime;           // 记录事件 “就绪” 的时刻
    protected final Duration delayTime;  // 延时 “就绪”

    // 因为其默认的行为是基于时间去执行控制，这部分默认的行为可以抽象出来，所以使用 “抽象类” 而非 “接口”。
    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start(); // 构造事件的时候，写入一次 “就绪” 时刻
    }

    // 每次重启，都重新记录 一次最新的 “就绪” 时刻
    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }

    /**
     * 是否 “就绪”
     * @return
     */
    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    // 控制框架并不包含任何 具体的信息。
    // 那些信息是在实现算法的 action() 部分时，通过继承来提供的。
    public abstract void action();
}
