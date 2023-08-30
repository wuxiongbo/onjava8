// onjava/Range.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Create arrays initialized with integer values.

/**
 * @author 10027088
 */
public class Range {

    //  创建序列[start, ..., end)，按 步长 增加
    public static int[] range(int start, int end, int step) {

        // 参数校验
        if (step == 0)
            throw new IllegalArgumentException("Step cannot be zero");


        // 初始化数组
        int sz = Math.max(0,
                step >= 0 ? (end + step - 1 - start) / step : (end + step + 1 - start) / step
        );
        int[] result = new int[sz];

        // 填充数据
        for (int i = 0; i < sz; i++) {
            result[i] = start + (i * step);
        }


        return result;
    }


    // Produce a sequence [start..end)
    public static int[] range(int start, int end) {
        return range(start, end, 1);
    }


    // Produce a sequence [0..n)
    public static int[] range(int n) {
        return range(0, n);
    }

}
