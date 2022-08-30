// collectiontopics/NavMap.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// NavigableMap produces pieces of a Map
import java.util.*;
import java.util.concurrent.*;

public class NavMap {
  public static final
  NavigableMap<Integer,String> COLORS =
    new ConcurrentSkipListMap<>(HTMLColors.MAP);
  public static void main(String[] args) {
    HTMLColors.show(COLORS.firstEntry());
    HTMLColors.border();
    HTMLColors.show(COLORS.lastEntry());
    HTMLColors.border();
    NavigableMap<Integer, String> toLime =
      COLORS.headMap(HTMLColors.rgb("Lime"), true);
    HTMLColors.show(toLime);
    HTMLColors.border();
    HTMLColors.show(COLORS.ceilingEntry(HTMLColors.rgb("DeepSkyBlue") - 1));
    HTMLColors.border();
    HTMLColors.show(COLORS.floorEntry(HTMLColors.rgb("DeepSkyBlue") - 1));
    HTMLColors.border();
    HTMLColors.show(toLime.descendingMap());
    HTMLColors.border();
    HTMLColors.show(COLORS.tailMap(HTMLColors.rgb("MistyRose"), true));
    HTMLColors.border();
    HTMLColors.show(COLORS.subMap(
      HTMLColors.rgb("Orchid"), true,
      HTMLColors.rgb("DarkSalmon"), false));
  }
}
/* Output:
0x000000: Black
******************************
0xFFFFFF: White
******************************
0x000000: Black
0x000080: Navy
0x00008B: DarkBlue
0x0000CD: MediumBlue
0x0000FF: Blue
0x006400: DarkGreen
0x008000: Green
0x008080: Teal
0x008B8B: DarkCyan
0x00BFFF: DeepSkyBlue
0x00CED1: DarkTurquoise
0x00FA9A: MediumSpringGreen
0x00FF00: Lime
******************************
0x00BFFF: DeepSkyBlue
******************************
0x008B8B: DarkCyan
******************************
0x00FF00: Lime
0x00FA9A: MediumSpringGreen
0x00CED1: DarkTurquoise
0x00BFFF: DeepSkyBlue
0x008B8B: DarkCyan
0x008080: Teal
0x008000: Green
0x006400: DarkGreen
0x0000FF: Blue
0x0000CD: MediumBlue
0x00008B: DarkBlue
0x000080: Navy
0x000000: Black
******************************
0xFFE4E1: MistyRose
0xFFEBCD: BlanchedAlmond
0xFFEFD5: PapayaWhip
0xFFF0F5: LavenderBlush
0xFFF5EE: SeaShell
0xFFF8DC: Cornsilk
0xFFFACD: LemonChiffon
0xFFFAF0: FloralWhite
0xFFFAFA: Snow
0xFFFF00: Yellow
0xFFFFE0: LightYellow
0xFFFFF0: Ivory
0xFFFFFF: White
******************************
0xDA70D6: Orchid
0xDAA520: GoldenRod
0xDB7093: PaleVioletRed
0xDC143C: Crimson
0xDCDCDC: Gainsboro
0xDDA0DD: Plum
0xDEB887: BurlyWood
0xE0FFFF: LightCyan
0xE6E6FA: Lavender
*/
