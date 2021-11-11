// innerclasses/GreenhouseControls.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.

import controller.*;

/**
 * Greenhouse 恒温室
 *
 * 恒温室控制装置。
 *
 * 这是一个 产生了控制系统的 特定应用程序，所有事件都在这一个外部类中。
 * 内部类允许你 为每种类型的事件封装不同的功能实现。
 *
 */
public class GreenhouseControls extends Controller {




    // 控制框架   GreenhouseControls自身   并不包含任何具体的功能信息。
    // 那些功能信息是 由 继承自Event的内部类  所实现的action()算法  来提供的。









    // light 照明。 开、关 事件
    private boolean light = false;

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




    // water 加水。 开、关 事件
    private boolean water = false;

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
    private String thermostat = "Day";
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

            this.eventList = eventList; // 重启事件的构造方法中，将事件列表   放一份在 重启事件中

            for (Event e : eventList)   // 重启事件的构造方法中，还将事件列表  放一份在了 控制器 中
                addEvent(e);
        }

        @Override
        public void action() {
            for (Event e : eventList) {   // 遍历 重启事件中 维护的 事件列表
                e.start();  // 更新 事件列表 中的事件所维护 的“就绪”时刻
                addEvent(e);
            }
            start(); // 更新 本重启事件 维护的 “就绪”时刻
            addEvent(this); // 再添加一遍 重启事件，以实现可无限重启。直到系统终止
        }
        // 在action运行完的这一刻，Restart事件在 控制器 中存有两份。 紧接着，控制器 会remove掉一份。

        @Override
        public String toString() {
            return "Restarting system";
        }
    }






    // Terminate 终止事件
    // 注意，这是个static修饰的 嵌套类。
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
