// reuse/Car.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Composition with public objects
// 使用公共对象来实现组合

class Engine {
    public void start() {
    }

    public void rev() {
    }

    public void stop() {
    }
}

class Wheel {
    public void inflate(int psi) {
    }
}

class Window {
    public void rollup() {
    }

    public void rolldown() {
    }
}

class Door {
    public Window window = new Window();

    public void open() {
    }

    public void close() {
    }
}

/**
 * 继承 还是 组合？
 *
 * 当使用继承时，你通过现有的类来生成它的一个特殊版本。这通常意味着对通用类进行定制，使它可以用于特定需求。
 * 稍加思考你就会发现，用一个“交通工具”对象来组合成一部“汽车”是亳无意义的—— ‘汽车’ 并不包含 ‘交通工具’，‘汽车’ 是一种 交通工具。
 *
 * “继承”是用来表示“is-a”关系的，
 * 而
 * “组合”是用来表示“has-a”关系的。
 *
 *
 */
public class Car {

    // 对于新类里通过组合得到的成员，有时候允许类的使用者直接访问它们是合理的。
    // 为此，可以将成员对象设为public（你可以将其视为一种“半委托”）。
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door(); // 2-door


    public Car() {
        for (int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
    }
}
