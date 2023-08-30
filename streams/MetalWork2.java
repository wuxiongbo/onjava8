
// streams/MetalWork2.java

import java.util.*;

/**
 * @author Xander Wu
 * @date 2023/7/26 11:26
 */
public class MetalWork2 {
    public static void main(String[] args) {
        Arrays.stream(new Operation[]{
                () -> Operation.show("Heat"),
                () -> Operation.show("Hammer"),
                () -> Operation.show("Twist"),
                () -> Operation.show("Anneal")
        }).forEach(Operation::execute);
    }

}