// references/OceanReading.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Cloning a composed object
package references;

public class OceanReading implements Cloneable {
  private references.DepthReading depth;
  private references.TemperatureReading temperature;
  public
  OceanReading(double tdata, double ddata) {
    temperature = new references.TemperatureReading(tdata);
    depth = new references.DepthReading(ddata);
  }
  @Override public OceanReading clone() {
    OceanReading or = null;
    try {
      or = (OceanReading)super.clone();
    } catch(CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
    // Must clone references:
    or.depth = (references.DepthReading)or.depth.clone();
    or.temperature =
      (references.TemperatureReading)or.temperature.clone();
    return or;
  }
  public references.TemperatureReading getTemperatureReading() {
    return temperature;
  }
  public void
  setTemperatureReading(references.TemperatureReading tr) {
    temperature = tr;
  }
  public references.DepthReading getDepthReading() {
    return depth;
  }
  public void setDepthReading(references.DepthReading dr) {
    this.depth = dr;
  }
  @Override public String toString() {
    return "temperature: " + temperature +
      ", depth: " + depth;
  }
}
