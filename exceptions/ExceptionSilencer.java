// exceptions/ExceptionSilencer.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // 在finally块中使用return，
            // 会把任何被抛出的异常都压制下来
            return;
        }
    }
}
