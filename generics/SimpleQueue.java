// generics/SimpleQueue.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A different kind of Iterable collection

import java.util.*;

/**
 * apply() 方法 还可以接受其他任何事物，只要能够使这些事物是 Iterable 的
 *
 * 正如反射解决方案看起来那样优雅，我们必须观察到，反射通常比非反射实现要慢（尽管在 Java 的最新版本中得到了显着改进），
 * 因为在运行时，发生了很多事情。但它不应阻止您尝试这种解决方案，这依然是值得考虑的一点。
 *
 *
 * 这里，对 ApplyTest.java 进行了重写，以利用 Java 8 的流和函数工具：
 * generics/ApplyFunctional.java
 *
 * @param <T>
 */
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
