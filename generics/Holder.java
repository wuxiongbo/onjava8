// generics/Holder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Objects;

/**
 * 编译器有多聪明?
 *
 *
 *
 * @param <T>
 */
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Holder
                &&
                Objects.equals(value, ((Holder) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }



    public static void main(String[] args) {

        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);


        // Holder<Apple> 不能将其向上转型为 Holder<Fruit>
        // Holder<Fruit> Fruit = apple; // Cannot upcast


        // 但是，Holder<Apple> 可以向上转型为 Holder<? extends Fruit>
        Holder<? extends Fruit> fruit = apple; // OK


        // 调用 get()，只能返回一个 Fruit
        //    —— 这就是在给定 <? extends Fruit> “任何扩展自 Fruit 的对象”  这一边界后，它所能知道的一切了。
        Fruit p = fruit.get();



        // 如果你知道更多的信息，就可以将其转型到某种具体的 Fruit 而不会导致任何警告
        d = (Apple) fruit.get(); // Returns 'Object'
        try {
            // 虽然编译时期不产生任何警告，但是，存在 运行时期 得到 ClassCastException 的风险。
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e); // ClassCastException
        }


        // set() 方法不能工作在 Apple 和 Fruit 上，因为 set() 的参数也是 “? extends Fruit”，
        // 这意味着，它 可以是 “任何事物”，编译器无法验证 “任何事物” 的类型安全性。
        // fruit.set(new Apple()); // Cannot call set()
        // fruit.set(new Fruit()); // Cannot call set()


        // 但是，equals() 方法 是可以正常工作的，因为它接受的参数是 “Object” 而不是 “T类型”。
        System.out.println(fruit.equals(d)); // OK


        // 上面的示例可以看到，get()方法 返回的 Fruit，可以再次强制转型为， 任意  某种具体的 Fruit 类型
        // 因此，我们可以发现，编译器只关注 “传递进来” 和 “要返回” 的对象类型。 （注意是 “要返回”， “已返回” 的则管不着）

        // 所以，编译器 不会分析代码，以查看是否执行了任何实际的 “写入” 和 “读取” 操作。

    }
}
/* Output:
java.lang.ClassCastException: Apple cannot be cast to
Orange
false
*/
