// innerclasses/controller/Controller.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The reusable framework for control systems
package controller;

import java.util.*;

/**
 * 这是一个控制框架
 * 它的工作就是，在事件 “就绪” 的时候执行事件。
 *
 * 虽然 怎么样算“就绪”  这个标准可以是任何事物，但在本例中，是指 基于 时间 触发的 “就绪”
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
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for (Event e : new ArrayList<>(eventList)){
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
