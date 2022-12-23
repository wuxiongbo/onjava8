// functional/ConsumeFunction.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

class One {
}

class Two {
}

public class ConsumeFunction {
    /**
     * 要接受并使用函数，方法 必须在其参数列表中，正确地描述 函数类型
     *
     * @param onetwo
     * @return
     */
    static Two consume(Function<One, Two> onetwo) {
        return onetwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
