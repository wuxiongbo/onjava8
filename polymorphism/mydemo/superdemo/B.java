package mydemo.superdemo;

/**
 * @author Xander Wu
 * @date 2022/10/13 21:02
 */
public class B extends A{
    @Override
    protected void msg(){
        super.msg();
        System.out.println("Im B");
    }
}
