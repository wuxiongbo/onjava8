// reuse/PlaceSetting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Combining composition & inheritance

/**
 * 组合 与 继承 相结合
 */
// 盘子
class Plate {
    Plate(int i) {
        System.out.println("Plate constructor");
    }
}

// 西餐用的大盘子
class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor");
    }
}

// （尤指厨房或家用的）用具
class Utensil {
    Utensil(int i) {
        System.out.println("Utensil constructor");
    }
}

// 勺
class Spoon extends Utensil {
    Spoon(int i) {
        super(i); // 尽管编译器会强制你初始化基类，并要求在构造器一开头就执行，但它不会监督你是否的确初始化了成员对象。
        System.out.println("Spoon constructor");
    }
}

// 叉
class Fork extends Utensil {
    Fork(int i) {
        super(i);
        System.out.println("Fork constructor");
    }
}

// 刀
class Knife extends Utensil {
    Knife(int i) {
        super(i);
        System.out.println("Knife constructor");
    }
}

// 风俗，习俗
class Custom {
    Custom(int i) {
        System.out.println("Custom constructor");
    }
}

// 成套餐具、地方设置、背景
public class PlaceSetting extends Custom {  // 继承

    // 组合
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;


    public PlaceSetting(int i) {

        super(i + 1);

        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);

        System.out.println("PlaceSetting constructor");
    }


    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }

}
/* Output:
Custom constructor
Utensil constructor
Spoon constructor
Utensil constructor
Fork constructor
Utensil constructor
Knife constructor
Plate constructor
DinnerPlate constructor
PlaceSetting constructor
*/
