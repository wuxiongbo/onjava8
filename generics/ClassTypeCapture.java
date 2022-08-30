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
 * @see Erased
 *
 * 对于 泛型擦除 的 补偿： 引入 class“类型标签”
 *
 * 本示例：判断 “类型标签” 与 “泛型参数” 是否匹配
 *
 * 在前面的程序中，由于类型信息被擦除了，因此使用instanceof的尝试失败了。
 * 而类型标签，则可以提供动态的isInstance()能力
 * 编译器保证了  '类型标签'  能够和  '泛型参数'  匹配
 *
 *
 * @param <T>
 */
public class ClassTypeCapture<T> {

    //  通过引入 “类型标签”  保存泛型类型。   kind  种类；
    private Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);  // 引入 class“类型标签” ，解决了泛型不能作 类型判断 的问题。error: arg instanceof T
    }



    public static void main(String[] args) {

        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);

        // Class<Building> kind;
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
