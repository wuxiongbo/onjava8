package MyDemo;// innerclasses/Sequence.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Holds a sequence of Objects

interface Selector {
    boolean end();

    Object current();

    void next();
}

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

    // 如果 Sequence 不使用内部类，就必须声明 “Sequence 是一个Selector”，
    // 对于某个特定的 Sequence 只能有一个 Selector，
    // 而使用内部类很容易就能拥有另一个方法 reverseSelector()，用它来生成一个反方向遍历序列的 Selector，只有内部类才有这种灵活性。
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

    // 使用内部类，实现 反方向遍历序列 。  实现忽略
    private class SequenceReverseSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return false;
        }

        @Override
        public Object current() {
            return null;
        }

        @Override
        public void next() {
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
    public Selector reverseSelector() {
        return new SequenceReverseSelector();
    }

    public static void main(String[] args) {
//        Sequence sequence = new Sequence(10);
//        for (int i = 0; i < 10; i++)
//            sequence.add(Integer.toString(i));
//
//
//        Selector selector = sequence.selector();
//        while (!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.next();
//        }

    }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
*/
