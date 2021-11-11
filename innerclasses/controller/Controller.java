// innerclasses/controller/Controller.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The reusable framework for control systems
package controller;

import java.util.*;

/**
 * 这是一个控制框架。
 *
 * 它的工作就是，在事件 “就绪” 的时候执行事件。
 *
 * 虽然 怎么样算“就绪”  这个标准可以是任何事物，但在本例中，是指 基于 时间 触发的 “就绪”
 *
 * 在目前的设计中，你并不知道 Event 到底做了什么。
 * 这正是此设计的关键所在——“使 变化的事物 与 不变的事物 相互分离”。
 * 用我的话说，“变化向量” 就是 各种 不同的Event对象 所具有的 不同行为，而你通过创建不同的 Event 子类来表现不同的行为。
 *
 * 这正是内部类要做的事情，内部类允许：
 * 1. 控制框架 的完整实现是由 单个的类 创建的，从而使得 ‘实现的细节’ 被 “封装” 了起来。
 *    内部类 用来表示 解决问题所必需的各种不同的 action()。
 *
 * 2. 内部类 能够很容易地访问 外部类 的 任意成员，所以 可以避免这种实现变得笨拙。
 *    如果没有这种能力，代码将变得令人讨厌，以至于你肯定会选择别的方法。
 *
 *
 */
public class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }


    public void run() {
        while (eventList.size() > 0){
            // Make a copy so you're not modifying the list while you're selecting the elements in it:
            // 复制一份集合，这样 修改原集合 就不会影响  迭代新集合中的元素:
            for (Event e : new ArrayList<>(eventList)){
                if (e.ready()) {
                    System.out.println(e);

                    e.action();          // 可能会有 为集合新增元素的动作

                    eventList.remove(e); // 为集合删除元素
                }
            }

            //  使用迭代器的方式 虽然可以 遍历移除元素，但不能 遍历添加元素
//            Iterator<Event> iterator = eventList.iterator();
//            while(iterator.hasNext()){
//                Event e = iterator.next();
//                if (e.ready()) {
//                    System.out.println(e);
//                    e.action();
//                    iterator.remove();
//                }
//            }

        }
    }
}
