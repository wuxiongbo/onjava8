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
 * 内部类允许你为每种类型的事件封装不同的功能。
 *
 */
public class GreenhouseControls extends Controller {

    // light 照明。 开、关 事件
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
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
            // Put hardware control code here to
            // physically turn off the light.
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
            // Put hardware control code here.
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
            // Put hardware control code here.
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
            // Put hardware control code here.
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
            // Put hardware control code here.
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }





    // Bell 响铃事件
    // An example of an action() that inserts a new one of itself into the event list:
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

            this.eventList = eventList; // 构造重启事件的时候，将事件列表  放一份在 重启事件中

            for (Event e : eventList)   // 构造重启事件的时候，将事件列表  再放一份到 控制器 中
                addEvent(e);
        }

        @Override
        public void action() {
            for (Event e : eventList) {   // 遍历 重启事件中 维护的 事件列表
                e.start();  // 更新 事件列表中的事件 内部维护 的“就绪”时刻
                addEvent(e);
            }
            start(); // 更新 当前事件 内部维护的 “就绪”时刻
            addEvent(this); // 可无限重启。直到系统终止
        }
        // action运行完后，Restart事件在控制器中存有两份。 紧接着remove一份。

        @Override
        public String toString() {
            return "Restarting system";
        }
    }






    // Terminate 终止事件
    // 注意，这是个嵌套类
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
