// generics/CaptureConversion.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with captured type
    }

    /**
     * 捕获参数类型
     * 要求在传递 Holder<?> 时同时传递一个具体类型。
     *    捕获转换只有在这样的情况下可以工作：即在方法内部，你需要使用确切的类型。
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Holder raw = new Holder<>(1);
        f1(raw);
        f2(raw); // No warnings


        Holder<Integer> qualify = new Holder<>(1);
        f2(qualify); // No warnings


        Holder rawBasic = new Holder(new Object());
        f2(rawBasic); // No warnings


        Holder<?> wildcarded = new Holder<>(1.0); // Upcast to Holder<?>, still figures it out:
        f2(wildcarded);


    }

}
/* Output:
Integer
Integer
Object
Double
*/
