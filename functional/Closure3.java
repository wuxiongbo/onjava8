// functional/Closure3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

public class Closure3 {
    IntSupplier makeFun(int x) {
        AtomicInteger i = new AtomicInteger();
        // Neither x++ nor i++ will work:
        AtomicInteger finalX = new AtomicInteger(x);
        return () -> finalX.getAndIncrement() + i.getAndIncrement();
    }
}
