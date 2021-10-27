// generics/ClassTypeCapture.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// 建筑
class Building {
}
// 房子
class House extends Building {
}

/**
 * 上接  generics/Erased.java
 *
 * 对于 泛型擦除 的 补偿： 引入 “类型标签”
 * 本示例：判断 “类型标签” 与 “泛型参数” 是否匹配
 *
 * 由于擦除了类型信息，因此在上一个程序中，尝试使用 instanceof 将会失败。
 * 而本示例中，‘类型标签’ 则可以使用动态 isInstance()。 这意味着，将由 ‘编译器’ 来判断，保证 “类型标签” 与 “泛型参数” 相匹配。
 *
 * @param <T>
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);  // 引入 “类型标签” ，解决了泛型不能作 类型判断 的问题。error: arg instanceof T
    }

    public static void main(String[] args) {

        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building())); // 建筑 是 建筑类型    true
        System.out.println(ctt1.f(new House()));    // 房子 是 建筑类型    true

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building())); // 建筑 不是 房子类型   false
        System.out.println(ctt2.f(new House()));    // 房子 是   房子类型   true

    }
}
/* Output:
true
true
false
true
*/
