package controller.impl;// innerclasses/controller.impl.GreenhouseController.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Configure and execute the greenhouse system

import controller.*;

public class GreenhouseController {

    public static void main(String[] args) {
        // 1.初始化系统
        GreenhouseControls gc = new GreenhouseControls();

        // 2.添加所有相应的事件。  你可以从文本文件中解析配置信息，而不是使用代码:

        // 1)将 “响铃事件” 加入控制器。
        gc.addEvent(gc.new Bell(9000));      // 响铃        事件

        // 构建 事件列表。  这是 “命令设计模式” 的一个例子—— eventList 中的每个对象都被封装成对象的请求
        Event[] eventList = {
                gc.new ThermostatNight(0),   // 恒温器 夜间模式 事件
                gc.new LightOn(2000),        // 开关照明灯      事件
                gc.new LightOff(4000),
                gc.new WaterOn(6000),        // 开关水         事件
                gc.new WaterOff(8000),
                gc.new ThermostatDay(14000)  // 恒温器 日间模式 事件
        };

        // 2)将 “重启事件” 加入控制器。 构造 重启事件 时，要将 需重启的事件列表 作为构造参数传入。
        gc.addEvent(gc.new Restart(20000, eventList));// 重启事件

        // 3)将 “终止事件” 加入控制器。
        gc.addEvent(new GreenhouseControls.Terminate(50000)); // 终止事件


        gc.run();
    }

}
/* Output:
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Bing!
Thermostat on day setting
Bing!

Restarting system

Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Bing!
Greenhouse water is off
Thermostat on day setting
Bing!

Restarting system

Thermostat on night setting
Light is on
Light is off
Bing!
Greenhouse water is on
Greenhouse water is off

Terminating
*/
