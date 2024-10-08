// interfaces/interfaceprocessor/StringProcessor.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java interfaces.interfaceprocessor.StringProcessor}
package interfaceprocessor;

import java.util.*;

/**
 * [1] 这个声明是不必要的，如果删除它，编译器也不会提示错误。但它能指出方法的返回值从Object协变为String。
 * [2] 字段s自动是static和final的，因为它是在接口内定义的。
 * [3] 你甚至可以在接口中定义一个main()方法。
 *
 */
interface StringProcessor extends Processor {
    @Override
    String process(Object input);        // [1]

    String S =                           // [2]
            "If she weighs the same as a duck, " + "she's made of wood";

    static void main(String[] args) {    // [3]
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }
}

class Upcase implements StringProcessor {
    @Override // Covariant return:
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
/* Output:
Using Processor Upcase
IF SHE WEIGHS THE SAME AS A DUCK, SHE'S MADE OF WOOD
Using Processor Downcase
if she weighs the same as a duck, she's made of wood
Using Processor Splitter
[If, she, weighs, the, same, as, a, duck,, she's, made,
of, wood]
*/
