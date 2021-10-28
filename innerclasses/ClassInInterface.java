// innerclasses/ClassInInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java ClassInInterface$Test}

/**
 * 放到接口中的任何类都自动地 加上了 public 和 static 。
 */
public interface ClassInInterface {
    void howdy();

    // 接口中的 成员会自动加上  public static ，所以本 Test 类是嵌套类。
    // 嵌套类 甚至可以实现其 直接的外部接口 ClassInInterface
    /*public static*/ class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
/* Output:
Howdy!
*/
