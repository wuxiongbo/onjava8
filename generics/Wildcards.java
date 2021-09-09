// generics/Wildcards.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Exploring the meaning of wildcards

/**
 * 编译器何时才会关注 "原生类型" 和 "涉及无界通配符的类型" 之间的差异呢？
 */
public class Wildcards { // Wildcards 通配符


    // 原生类型。  擦除参数
    // Raw argument:
    // Holder 原生类型
    static void rawArgs(Holder holder, Object arg) {

        // 由于它是原生类型，你可以将任何类型的对象传递给 set() ，而这个对象将被向上转型为 Object。
        // 因此无论何时，只要使用了原生类型，都会放弃编译期检查。
        holder.set(arg);


        // Can't do this; don't have any 'T':
        // T t = holder.get();

        // get()的调用说明了相同的问题： 没有任何 T 类型的对象，因此结果只能是一个 Object。
        Object obj = holder.get(); // OK, but type information is lost:
    }


    // 无界通配符
    // Like rawArgs(), but errors instead of warnings:
    // 强调 Holder 与 Holder<?> 是不同的
    static void unboundedArg(Holder<?> holder, Object arg) {

        // 因为 原生 Holder 将持有  “任何类型”  的组合，
        // 而 Holder<?> 将持有 “具有某种具体类型” 的同构集合，因此不能只是向其中传递 Object 。
        // holder.set(arg);


        // Can't do this; don't have any 'T':
        // 不能这么做; 没有任何 'T' 类型:
        // T t = holder.get();



        // 虽然可以，但是 类型信息丢失：
        Object obj = holder.get();  // OK, but type information is lost:

    }



    /**
     *  确切类型
     *
     *  使用 确切类型 来替代通配符类型的好处是，可以用泛型参数来做更多的事
     *
     *  exact1() 和 exact2() ，使用了确切的泛型参数——没有任何通配符。
     *  你将看到，exact2() 与 exact1() 具有不同的限制，因为它有额外的参数。
     * @param holder
     * @param <T>
     * @return
     */
    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }



    // 使用通配符使得你必须接受范围更宽的参数化类型作为参数

    /**
     * 子类型通配符。
     *
     * 从泛型参数中返回类型确定的返回值
     *
     * 在 wildSubtype() 中，在 Holder 类型上的限制被放松为包括持有任何扩展自 T 的对象的 Holder 。
     * 这还是意味着如果 T 是 Fruit ，那么 holder 可以是 Holder<Apple> ，这是合法的。
     * @param holder
     * @param arg
     * @param <T>
     * @return
     */
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {

        // 这是合法的。
        Holder<? extends Fruit> holder1 = new Holder<Apple>();

        // 为了防止将 Orange 放置到Holder<Apple> 中，
        // 对 set() 的调用（或者对任何接受这个类型参数为参数的方法的调用）都是不允许的。
//        holder.set(arg);

        return holder.get();
    }
    /**
     * 超类型 通配符。
     *
     * 向泛型参数传递类型确定的参数
     *
     * 这个方法展示了与 wildSubtype()相反的行为：
     * @param holder
     * @param arg
     * @param <T>
     */
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {

        // holder 可以是持有任何 T 的基类型的容器。因此，set() 可以接受 T
        holder.set(arg);

        // 但是，尝试着调用 get() 是没有用的，因为由 holder 持有的类型可以是任何超类型，
//        T t = holder.get();


        // 因此，唯一安全的类型就是 Object 。
        Object obj = holder.get();  // OK, but type information is lost:

    }





    public static void main(String[] args) {
        // 检查类型，以接收参数的类型为准。

        // 原生类型
        Holder raw = new Holder<>();
        raw = new Holder(); // Or:
        // 限定类型
        Holder<Long> qualified = new Holder<>();
        // 无界
        Holder<?> unbounded = new Holder<>();
        // 有界
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;




        // 为了迁移兼容性，rawArgs() 将接受所有  Holder 的变体（原生、确切泛型、边界、逆变、无界），而不会产生警告。
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);




        // unboundedArg() 方法也可以接受相同的所有类型，尽管如前所述，unboundedArg 方法体内部处理这些类型的方式 与 rawArgs 并不相同。
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);




        // 如果向接受 “确切” 泛型类型（没有通配符）的方法传递一个原生 Holder 引用，就会得到一个警告，
        // 因为，确切的参数期望得到在原生类型中并不存在的信息。


        Object r1 = exact1(raw); // 原生类型 编译警告
        Long r2 = exact1(qualified);
        // 如果向 exact1() 传递一个无界引用，就不会有任何可以确定返回类型的类型信息。
        Object r3 = exact1(unbounded); // Must return Object
        Long r4 = exact1(bounded);
        Long r5 = exact2(raw, lng);  // 原生类型 编译警告
        Long r6 = exact2(qualified, lng);
        // 带通配符的类型，无法传入到 参数列表需要“确切类型”的方法。
//        Long r7 = exact2(unbounded, lng); // 编译报错
//        Long r8 = exact2(bounded, lng); // 编译报错




        // 子类型通配符
        Long r9 = wildSubtype(raw, lng);  // 原生类型 编译警告
        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng); // OK, but can only return Object:
        Long r12 = wildSubtype(bounded, lng);





        // 超类型通配符
        wildSupertype(raw, lng);  // 原生类型 编译警告
        wildSupertype(qualified, lng);
//        wildSupertype(unbounded, lng);
//        wildSupertype(bounded, lng);



    }



}
