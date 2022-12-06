// polymorphism/music/Wind.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package music;

// 管乐器（Wind）是一种乐器（Instrument）。因此，Wind可以继承Instrument：
// Wind对象是一种Instrument
// 因为它们有相同的接口：
public class Wind extends Instrument {
    // Redefine interface method:
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
