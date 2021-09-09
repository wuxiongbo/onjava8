// generics/ErasureAndInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

/**
 * Derived2 继承自 GenericBase，但是没有任何类型参数，编译器没有发出任何警告。
 * 直到调用 set() 方法时才出现警告。
 */
class Derived2 extends GenericBase {
} // No warning


// class Derived3 extends GenericBase<?> {}
// Strange error:
//   unexpected type
//   required: class or interface without bounds

public class ErasureAndInheritance {

//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Derived2 d2 = new Derived2();
        Object obj = d2.get();

        d2.set(obj);
        // Warning here!

    }

}
