package org.example;

public class App {

    public int add2Numbers(int a, int b) {
        return a + b;
    }

    public String trimNullSafe(String str) {
        return str == null ? "" : str.trim();
    }

    public int getFirstInt(int[] intAry) {
        return intAry[0];
    }

    public int squareNumber(int a) {
        return a * a;
    }
}