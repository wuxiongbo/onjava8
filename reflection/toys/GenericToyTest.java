// reflection/toys/GenericToyTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Testing class Class
// {java reflection.toys.GenericToyTest}
package toys;


/**
 * ftc.getSuperclass() 不能被声明为 Class<Toy>
 * 这看起来有点儿奇怪，
 * 因为， getSuperclass()返回了基类（不是接口），而编译器在编译时，明明知道这个基类是Toy.class，而不仅仅是“FancyToy的某个基类”
 *
 * 只能使用  Class<? super FancyToy>  这种模糊性的声明，
 * 导致 up.getConstructor().newInstance() 的返回值只能是一个Object
 *
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftc = FancyToy.class;
        // 生成确切的类型:
        FancyToy fancyToy = ftc.getConstructor().newInstance();

        Class<? super FancyToy> up = ftc.getSuperclass();
        // 无法通过编译:
        // Class<Toy> up2 = ftc.getSuperclass();
        // 只能产生 Object:
        Object obj = up.getConstructor().newInstance();
    }
}
