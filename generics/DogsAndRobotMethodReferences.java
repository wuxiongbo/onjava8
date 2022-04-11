// generics/DogsAndRobotMethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// "Assisted Latent Typing"

import pets.Dog;

import java.util.function.*;

class PerformingDogA extends Dog {

    public void speak() {
        System.out.println("Woof!");
    }

    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class RobotA {

    public String name="default name";

    public RobotA() {
    }

    public <T> RobotA(T t) {
        String s = t.toString();
        name = s;
    }

    public void speak() {
        System.out.println("Click!");
    }

    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {
    }
}

/**
 * Java8 中的辅助潜在类型。 使代码编写更加灵活
 */
class CommunicateA {
    public static <P> void perform(P performer, Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

/**
 * 对比 DogsAndRobots
 *
 * 不需要再继承 公共接口，来调用公共方法。
 *
 */
public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        // 之所以称其为 “辅助”，是因为您必须 显式地为 perform() 提供要使用的方法引用。它不能只按名称调用方法。
        CommunicateA.perform(new PerformingDogA(), PerformingDogA::speak, PerformingDogA::sit);
        CommunicateA.perform(new RobotA(), RobotA::speak, RobotA::sit);
        CommunicateA.perform(new Mime(), Mime::walkAgainstTheWind, Mime::pushInvisibleWalls);




        // 方法引用

        // 1.消费型
        //   in->process
        Consumer<Mime> action1 = new Consumer<Mime>(){
            @Override
            public void accept(Mime o) {

                //同  Mime::walkAgainstTheWind
                // o.walkAgainstTheWind();
                o.walkAgainstTheWind(o.toString());
            }
        };
        Consumer<Mime> action2 = new Consumer<Mime>(){
            @Override
            public void accept(Mime o) {

                //同  Mime::pushInvisibleWalls
                // o.pushInvisibleWalls();
                o.pushInvisibleWalls(o);
            }
        };
        doConsumer(new Mime(), Mime::walkAgainstTheWind, Mime::pushInvisibleWalls);
        doConsumer(new Mime(), action1, action2);

        // 2.函数型（数据处理型）
        //   in->process->out
        Function<Mime, RobotA> action = new Function<Mime, RobotA>() {
            @Override
            public RobotA apply(Mime mime) {

                //同  RobotA::new
//                return new RobotA(mime);

                // 不同于 RobotA::new
                return new RobotA();
            }
        };
        RobotA robotA = doFunction(new Mime(), RobotA::new);
        RobotA robotA1 = doFunction(new Mime(), action);
        System.out.println("robotA name " +robotA.name);
        System.out.println("robotA name " +robotA1.name);

        // 3.生产型
        //   process->out
        Supplier<RobotA> supplier = new Supplier<RobotA>() {
            @Override
            public RobotA get() {
                return new RobotA();
            }
        };
        RobotA robotA2 = doSupplier(RobotA::new);

    }

    static <T, R> R doFunction(T t, Function<T, R> function){
        R result = function.apply(t);
        return result;
    }

    /**
     * @param performer     数据源
     * @param action1       消费行为1
     * @param action2       消费行为2
     */
    static <P> void doConsumer(P performer, Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }

    static <T> T doSupplier(Supplier<T> supplier){
        T t = supplier.get();
        return t;
    }

}
/* Output:
Woof!
Sitting
Click!
Clank!
*/
