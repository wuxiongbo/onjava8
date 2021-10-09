// housekeeping/Leaf.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Simple use of the "this" keyword

public class Leaf {
    int i = 0;

    /**
     * 因为 increment() 通过 this 关键字返回当前对象的引用，
     * 因此在相同的对象上可以轻易地执行多次操作。
     * @return
     */
    Leaf increment() {
        i++;
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
/* Output:
i = 3
*/
