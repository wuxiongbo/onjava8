// patterns/doubledispatch/Aluminum.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Aluminum with double dispatching.
package patterns.doubledispatch;
import java.util.*;

public class Aluminum extends patterns.trash.Aluminum
implements patterns.doubledispatch.TypedBinMember {
  public Aluminum(double wt) { super(wt); }
  @Override
  public boolean addToBin(List<patterns.doubledispatch.TypedBin> tbins) {
    return tbins.stream()
      .anyMatch(tb -> tb.add(this));
  }
}
