// functional/FunctionWithWrapped.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

/**
 *
 * 函数式接口 的 基本类型变种 的唯一原因，就是————防止在 传递参数 和 返回结果 时，涉及 自动装箱 和 自动拆箱。
 * 也就是说，为了性能。
 *
 */
public class FunctionWithWrapped {
    public static void main(String[] args) {
        // 接口中使用包装类型
        Function<Integer, Double> fid = i -> (double) i;
        // 基本类型
        IntToDoubleFunction fid2 = i -> i;
    }
}
