// housekeeping/TerminationCondition.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using finalize() to detect an object that
// hasn't been properly cleaned up

class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void finalize() {
        if (checkedOut)
            System.out.println("Error: checked out");
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }
}

/**
 * 本例的终结条件是：所有的 Book 对象在被垃圾回收之前必须被登记。
 *
 * 但在 main()方法中，有一本书没有登记。
 * 要是没有 finalize() 方法来验证终结条件，将会很难发现这个 bug。
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();

        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();

        new onjava.Nap(1); // 延时一秒钟
    }
}
/* Output:
Error: checked out
*/
