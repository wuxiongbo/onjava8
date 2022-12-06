// polymorphism/music/Instrument.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package music;


// 管乐器（Wind）是一种乐器（Instrument）
class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}
