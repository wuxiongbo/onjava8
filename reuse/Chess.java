// reuse/Chess.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheritance, constructors and arguments
// 继承、构造器和参数

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        // 1) 如果不在BoardGame的构造器中 '显式'调用 "基类的构造器"，编译器会报错，表示它找不到形式为Game()的构造器。
        // 2) 对基类构造器的调用必须是 派生类构造器 的第一个操作（否则编译器会通过报错来提示）。
        super(i);

        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
/* Output:
Game constructor
BoardGame constructor
Chess constructor
*/
