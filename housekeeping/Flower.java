// housekeeping/Flower.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Calling constructors with "this"

/**
 * 通常当你说 this，意味着 “这个对象” 或 “当前对象”，它本身生成对当前对象的引用。
 * 在一个构造器中，当你给 this 一个参数列表时，它是另一层意思。
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println( "Constructor w/ int arg only, petalCount= " + petalCount);
    }

    Flower(String ss) {
        System.out.println( "Constructor w/ String arg only, s = " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals); // 当你给 this 一个参数列表时，它是另一层意思
        //- this(s); // 不能调用两次
        this.s = s; // Another use of "this"
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47); // 当你给 this 一个参数列表时，它是另一层意思
        System.out.println("Zero-argument constructor");
//        this("hi", 47); // 首先调用构造器(必须在第一行)，否则编译器会报错。
    }

    void printPetalCount() {
        //- this(11); // 不在无参构造内部！
        System.out.println( "petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
/* Output:
Constructor w/ int arg only, petalCount= 47
String & int args
Zero-argument constructor
petalCount = 47 s = hi
*/
