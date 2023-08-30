// exceptions/PreciseRethrow.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class BaseException extends Exception {
}

class DerivedException extends BaseException {
}

/**
 * 在Java 7之前，如果我们捕获了一个异常，那么只能重新抛出这种类型的异常。
 * 这会导致代码中出现不精确的问题，Java 7已经修复了。
 * 所以在Java 7之前，以下代码是无法通过编译的。
 * 因为catch捕获了一个BaseException，所以编译器会强制我们声明catcher() throws BaseException，尽管它实际上要抛出的是更具体的DerivedException。
 * 从Java 7开始，这段代码可以编译了，这个修复虽然很小，但很有用。
 *
 */
public class PreciseRethrow {
    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }
}
