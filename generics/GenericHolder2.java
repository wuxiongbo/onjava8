// generics/GenericHolder2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * public void set(java.lang.Object);
 *    0:    aload_0
 *    1:    aload_1
 *    2:    putfield #2;       //Field obj:Object;  擦除
 *    5:    return
 *
 * public java.lang.Object get();
 *    0:    aload_0
 *    1:    getfield #2;       //Field obj:Object;  擦除
 *    4:    areturn
 *
 * public static void main(java.lang.String[]);
 *    0:    new #3;           //class GenericHolder2
 *    3:    dup
 *    4:    invokespecial #4; //方法 "<init>":()V
 *    7:    astore_1
 *    8:    aload_1
 *    9:    ldc #5;           //String Item
 *    11:   invokevirtual #6; //Method set:(Object;)V
 *    14:   aload_1
 *    15:   invokevirtual #7; //Method get:()Object;
 *    18:   checkcast #8;     //class java/lang/String   看这里
 *    21:   astore_2
 *    22:   return
 *
 * 与 {@link SimpleHolder}
 * 得到的代码（字节码）完全相同。
 *
 * 泛型所有的行为都发生在边界———— 包括对 传入值 额外的编译时检查，和对 输出值 插入的类型转换。
 *

 *
 *
 * @param <T>
 */
public class GenericHolder2<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder2<String> holder = new GenericHolder2<>();
        holder.set("Item");
        String s = holder.get();


        // ClassCastException
//        Integer a = holder.get1();

    }

//    @SuppressWarnings("unchecked")
//    public <V> V get1(){
//        return (V)obj;
//    }

}
