// interfaces/filters/LowPass.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package filters;

/**
 * 低通滤波器
 */
public class LowPass extends Filter {
  double cutoff;
  public LowPass(double cutoff) {
    this.cutoff = cutoff;
  }
  @Override
  public Waveform process(Waveform input) {
    return input; // Dummy processing
  }
}
