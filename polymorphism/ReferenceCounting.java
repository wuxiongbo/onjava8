// polymorphism/ReferenceCounting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cleaning up shared member objects

class Shared {
    private int refcount = 0;
    /**
     * counter会跟踪创建的Shared实例的数量，它还为id提供了值。
     * counter的类型是long而不是int，以防止溢出（这里之所以这么做，只是因为它是一个良好实践，在本书的任何示例中都不太可能发生计数器溢出）
     */
    private static long counter = 0;
    /**
     * id 是 final的，因为一旦初始化就不应更改其值。
     */
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    // 引用
    public void addRef() {
        refcount++;
    }

    // 销毁
    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    // 销毁
    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}

/**
 * 清理共享对象
 * 本示例： Shared
 *
 * 当在你的类里使用共享对象时，必须记住调用addRef()，
 * 而dispose()方法会跟踪引用计数并决定何时才实际执行清理。
 *
 * 这种技术使用时需要加倍小心，但如果正在共享的对象需要清理，那么你就没有太多的选择了。
 *
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Composing[] composing = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };

        for (Composing c : composing)
            c.dispose();

    }
}
/* Output:
Creating Shared 0
Creating Composing 0
Creating Composing 1
Creating Composing 2
Creating Composing 3
Creating Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*/
