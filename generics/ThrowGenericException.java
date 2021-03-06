// generics/ThrowGenericException.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

interface Processor<T, E extends Exception> {
    /**
     * Processor 执行 process() 方法，并且可能会抛出具有 "类型E"  的异常。
     * process()的结果存储在 List<T>resultCollector 中（这被称为 收集参数 ）。
     * @param resultCollector
     * @throws E
     */
    void process(List<T> resultCollector) throws E;
}

/**
 * 存放 Processor，并收集 各Processor 的 执行结果。
 * @param <T>
 * @param <E>
 */
class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {

    // 如果不能参数化所抛出的异常，那么，由于检查型异常的缘故，将不能编写出这种泛化的代码。
    List<T> processAll() throws E {

        List<T> resultCollector = new ArrayList<>();  // 收集参数。 收集 Processor 的执行结果

        // 遍历执行 List容器中的 Processor
        for (Processor<T, E> processor : this)
            processor.process(resultCollector);

        return resultCollector;
    }

}

// 异常1
class Failure1 extends Exception {
}
// Processor实现1
class Processor1 implements Processor<String, Failure1> {
    static int count = 3;

    /**
     * 每执行一次，添加执行结果，并且计数器减一
     * @param resultCollector
     * @throws Failure1
     */
    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");

        if (count < 0)
            throw new Failure1();
    }
}

// 异常2
class Failure2 extends Exception {
}
// Processor实现2
class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    /**
     * 每执行一次，添加执行结果，并且计数器减一
     * @param resultCollector
     * @throws Failure1
     */
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0)
            resultCollector.add(47);
        else {
            resultCollector.add(11);
        }

        if (count < 0)
            throw new Failure2();
    }
}

public class ThrowGenericException {

    public static void main(String[] args) {

        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++)
            runner.add(new Processor1());

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }



        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++)
            runner2.add(new Processor2());

        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }

    }

}
/* Output:
[Hep!, Hep!, Ho!]
Failure2
*/
