// innerclasses/Sequence.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Holds a sequence of Objects

interface Selector {
    boolean end();

    Object current();

    void next();
}


/**
 * 内部类的作用： 链接外部类
 *
 * 到目前为止，内部类看上去就是一种名称隐藏和代码组织机制，虽然有用，但算不上惊艳。
 * 不过这里还有个奥妙之处。
 *      当创建一个内部类时，这个内部类的对象中会隐含一个 “链接” ，指向用于创建该对象的 外围对象。
 *      通过该 “链接” ，无须任何特殊条件，内部类对象 就可以访问 外围对象的成员。
 *      此外，内部类 拥有对 外围对象 所有元素的访问权。
 *
 *
 *
 * Sequence 是以类的形式包装起来的定长Object数组。
 *
 * 可以调用 add() 在序列末尾增加新的 Object（只要还有空间），
 * 要获取 Sequence 中的每一个对象，可以使用 Selector 接口。这是 “迭代器” 设计模式的一个例子，我们会在第12章进一步学习。
 *
 * 通过 Selector ，你可以：
 *      检查序列是否到末尾了（end()），
 *      访问当前对象（current()），
 *      以及 移到序列中的下一个对象（next()）。
 *
 * 因为 Selector 是一个接口，所以，别的类可以按它们自己的方式来实现这个接口，并且其他方法能以此接口为参数，来生成更加通用的代码。
 *
 */
public class Sequence {

    private Object[] items;

    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }



    // 如果 Sequence 不使用内部类，就必须声明 “Sequence 是一个Selector”
    // 对于某个特定的 Sequence 只能有一个 Selector，
    // 而使用内部类很容易就能拥有另一个方法 reverseSelector()，用它来生成一个反方向遍历序列的 Selector，只有内部类才有这种灵活性。

    /**
     * 这里，SequenceSelector 是一个提供 Selector 功能的 private 类。
     * 在 main()中，创建了一个 Sequence，并向其中添加了一些 String 对象。
     * 然后通过调用 selector()获取一个 Selector对象，并用它在 Sequence 中移动和选择每一个元素。
     *
     * 最初看到 SequenceSelector，可能会觉得它只不过是另一个内部类罢了。
     * 但请仔细观察它，注意方法 end()，current() 和 next() 都用到了 变量items ，这是一个引用，
     * items 并不是 SequenceSelector 的一部分，而是外部类中的一个 private 字段。
     * 然而，内部类可以访问其外部类的方法和字段，就像自己拥有它们似的，这带来了很大的方便，就如前面的例子所示。
     *
     * 所以，内部类自动拥有对其外部类所有成员的访问权。
     * 这是如何做到的呢？
     * 当某个外部类的对象创建了一个内部类对象时，此内部类对象必定会秘密地捕获一个指向那个外部类对象的引用。
     * 然后，在你访问此外部类的成员时，就是用那个引用来选择外部类的成员。
     * 幸运的是，编译器会帮你处理所有的细节，但你现在可以看到：
     *      内部类的对象只能在与其外部类的对象相关联的情况下才能被创建（就像你应该看到的，内部类是非static 类时）。
     *      内部类的对象在构造时，需要一个指向外围类对象的引用，如果编译器无法访问这个引用，它就会报错。不过这种情况大多不需要程序员干预。
     *
     */
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    // 构建内部类
    public Selector selector() {
        return new SequenceSelector();
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));


        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

}
/* Output:
0 1 2 3 4 5 6 7 8 9
*/
