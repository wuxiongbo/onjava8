// generics/EpicBattle.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Bounds in Java generics

import java.util.*;


interface SuperPower {
}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}
interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}
interface SuperSmell extends SuperPower {
    void trackBySmell();
}


class SuperHero<POWER extends SuperPower> {
    POWER power;

    SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}
class SuperSleuth<POWER extends XRayVision>
        extends SuperHero<POWER> {
    SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}
class CanineHero<POWER extends SuperHearing & SuperSmell>
        extends SuperHero<POWER> {
    CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

// 创建符合泛型约束的类型
class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() {
    }

    @Override
    public void trackBySmell() {
    }
}

// 继承 泛型边界最多的那个类。
class DogPerson extends CanineHero<SuperHearSmell> {
    DogPerson() {
        super(new SuperHearSmell());
    }
}


/**
 * 更多层次的示例
 */
public class EpicBattle {

    // 边界 在 泛型方法
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }
    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }


    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();

        useSuperHearing(dogPerson);
        superFind(dogPerson);


        // 通配符的使用

        // 你可以这样做
        List<? extends SuperHearing> audioPeople;
        // 但是你不可以这么做
        // List<? extends SuperHearing & SuperSmell> dogPs;

    }
}
