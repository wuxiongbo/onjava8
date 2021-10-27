// generics/CaptureConversion.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    // 这种特殊情况，需要使用 <?> 而不是 原生类型
    static void f2(Holder<?> holder) {
        f1(holder);  // 调用f1的时候，f1能进行类型的捕获。  <?> 在这里起了类型传递的作用。
    }

//    static void f3(Holder holder) {
//        f1(holder);
//    }

    /**
     * 捕获参数类型
     * 要求在传递 Holder<?> 时，同时传递一个具体类型。
     *    捕获转换只有在这样的情况下可以工作：即在方法内部，你需要使用确切的类型。
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Holder raw = new Holder<>(1);
//        f1(raw);
        f2(raw); // No warnings

        Holder<Integer> qualify = new Holder<>(1);
        f2(qualify); // No warnings


        Holder rawBasic = new Holder(new Object());
        f2(rawBasic); // No warnings


        Holder<?> wildcarded = new Holder<>(1.0); // Upcast to Holder<?>, still figures it out:
        f2(wildcarded);


//        System.out.println("-------");
//        f3(raw);
//        f3(qualify);
//        f3(rawBasic);
//        f3(wildcarded);

    }

}
/* Output:
Integer
Integer
Object
Double
*/
