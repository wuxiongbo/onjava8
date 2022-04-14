package controller.impl;// innerclasses/controller.impl.GreenhouseControls.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.

import controller.*;

/**
 * 这是一个控制器的实现。
 *
 * Greenhouse 恒温室
 * 恒温室控制装置。
 *
 * 这是一个 产生了控制系统的 特定应用程序，所有事件 都在这一个外部类中。
 * 该外部类的内部类允许你 为每种类型的事件封装不同的功能实现。
 *
 */
public class GreenhouseControls extends Controller {


    // 控制框架   GreenhouseControls自身   并不包含任何具体的功能信息，仅定义成员属性。
    //
    // 内部类可以随意访问 这些属性。
    // 所有的功能信息，都是 由继承自Event类的各个内部类 所实现的action()算法  来提供的。
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";



    // light 灯光。 开、关 事件
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 把硬件控制的代码放在这里，实现 开灯
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            //  把硬件控制的代码放在这里，实现 关灯
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    // water 水。 开、关 事件
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 把硬件控制代码放在这里
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 把硬件控制代码放在这里
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    // thermostat 恒温器。 日、夜  事件
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 把硬件控制代码放在这里
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 把硬件控制代码放在这里
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }




    // Bell 响铃事件
    // 一个action()的例子。将 自身事件 插入到 事件列表
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // 内部类是多么像多重继承：Bell 拥有 Event 的所有方法，也拥有外部类 GreenhouseContrlos 的所有方法
            addEvent(new Bell(delayTime.toMillis()));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }



    // Restart 重启事件
    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);

            this.eventList = eventList; // 将事件列表(不包括自己)  放一份在 本重启事件 Restart  中

            for (Event e : eventList)
                // 内部类 多么的像 “多重继承”：
                //    Restart类 拥有 父类Event 的所有方法，
                //    同时，也拥有 外部类 controller.impl.GreenhouseControls 的所有方法
                addEvent(e);            // 将事件列表  加到 控制器 Controller  中
        }

        @Override
        public void action() {

            for (Event e : eventList) {   // 遍历 本重启事件中 维护的 事件列表(不包括自己)
                e.start();                // 更新 事件列表 中的事件所维护 的“就绪”时刻
                addEvent(e);              // 又一次将事件列表(不包括自己)  加到 控制器 Controller  中
            }

            start();                      // 重置完 事件列表  的“就绪”时刻后， 更新 本重启事件 维护的 “就绪”时刻

            addEvent(this);            // 再次添加 本重启事件，将自身加入到 控制器 Controller，以实现可无限重启。直到系统终止

        }
        // 在action运行完的这一刻，Restart事件在 控制器 中存有两份。 紧接着，控制器 会remove掉一份。

        @Override
        public String toString() {
            return "Restarting system";
        }

    }



    // Terminate 终止事件
    // 注意：这个类，与前面的不太一样，它是个static修饰的 嵌套类。
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
