package mydemo.superdemo;

/**
 * @author Xander Wu
 * @date 2022/10/13 21:04
 */
public class C extends B {
    @Override
    protected void msg(){
        super.msg();
        System.out.println("im c");
    }
}
