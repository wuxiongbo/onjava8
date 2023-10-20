// exceptions/ExceptionMethods.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrating the Exception Methods

/**
 * @author 10027088
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");

            // 信息量递增
            // 1
            System.out.println("getMessage():" + e.getMessage());
            // 2
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            // 3
            System.out.println("toString():" + e.toString());
            // 4
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);

        }
    }
}
/* Output:
Caught Exception

getMessage():My Exception

getLocalizedMessage():My Exception

toString():java.lang.Exception: My Exception

printStackTrace():
java.lang.Exception: My Exception
        at
ExceptionMethods.main(ExceptionMethods.java:7)

*/
