// generics/SimpleHolder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 使用javap -c SimpleHolder对结果进行反编译
 *
 * public void set(java.lang.Object);
 *    0:    aload_0
 *    1:    aload_1
 *    2:    putfield #2; //Field obj:Object;
 *    5:    return
 *
 * public java.lang.Object get();
 *    0:    aload_0
 *    1:    getfield #2; //Field obj:Object;
 *    4:    areturn
 *
 * public static void main(java.lang.String[]);
 *    0:    new #3;           //class SimpleHolder
 *    3:    dup
 *    4:    invokespecial #4; //Method "<init>":()V
 *    7:    astore_1
 *    8:    aload_1
 *    9:    ldc #5;           //String Item
 *    11:   invokevirtual #6; //Method set:(Object;)V
 *    14:   aload_1
 *    15:   invokevirtual #7; //Method get:()Object;
 *    18:   checkcast #8;     //class java/lang/String   看这里
 *    21:   astore
 *    22:   return
 *
 * @see  GenericHolder2
 */
public class SimpleHolder {

    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();

        holder.set("Item");
        String s = (String) holder.get();

    }
}