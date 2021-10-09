// operators/Literals.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // 16 进制 (小写。 前导 0x 或 0X)
        System.out.println(
                "i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F; // 16 进制 (大写)
        System.out.println(
                "i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // 8 进制 (前导 0)
        System.out.println(
                "i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; // 最大 char 型 16 进制值
        System.out.println(
                "c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // 最大 byte 型 16 进制值 01111111;
        System.out.println(
                "b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // 最大 short 型 16 进制值
        System.out.println(
                "s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long 型后缀
        long n2 = 200l; // long 型后缀 (容易与数值 1 混淆)
        long n3 = 200;

        // Java 7 二进制字面值常量:
        byte blb = (byte) 0b00110101; // 二进制 （自 Java 7 引入。 前导 0b 或 0B ）
        System.out.println(
                "blb: " + Integer.toBinaryString(blb));
        short bls = (short) 0B0010111110101111;
        System.out.println(
                "bls: " + Integer.toBinaryString(bls));
        int bli = 0b00101111101011111010111110101111;
        System.out.println(
                "bli: " + Integer.toBinaryString(bli));
        long bll = 0b00101111101011111010111110101111;
        System.out.println(
                "bll: " + Long.toBinaryString(bll));
        float f1 = 1;
        float f2 = 1F; // float 型后缀
        float f3 = 1f; // float 型后缀
        double d1 = 1d; // double 型后缀
        double d2 = 1D; // double 型后缀
        // (Hex and Octal also work with long)
    }
}
/* Output:
i1: 101111
i2: 101111
i3: 1111111
c: 1111111111111111
b: 1111111
s: 111111111111111
blb: 110101
bls: 10111110101111
bli: 101111101011111010111110101111
bll: 101111101011111010111110101111
*/
