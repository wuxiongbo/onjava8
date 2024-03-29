// interfaces/filters/Filter.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package filters;

/**
 * 电子过滤器
 * {@link Applicator}
 */
public class Filter {
  public String name() {
    return getClass().getSimpleName();
  }
  public Waveform process(Waveform input) {
    return input;
  }
}
