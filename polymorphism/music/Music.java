// polymorphism/music/Music.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheritance & upcasting
// {java polymorphism.music.Music}
package music;

/**
 * 它接收一个Instrument引用。
 * 那么，编译器怎么可能知道这个 Instrument引用 在这里 指的  是Wind 而 不是Brass 或 Stringed ？
 *
 * 答案是，编译器是不知道的
 *
 */
public class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
/* Output:
Wind.play() MIDDLE_C
*/
