package com.example.patterns.decorator;

/**
 * For cases when you can't extend class.
 */
class MyDigitString {
    private String mString;

    public MyDigitString() {
        mString = new String();
    }

    public MyDigitString(String pString) {
        mString = pString;
    }

    @Override
    public String toString() {
        return mString.toString().replaceAll("\\D+","");
    }

    public int length() {
        return toString().length();
    }

    public boolean isEmpty() {
        return toString().isEmpty();
    }

    // Generate other String's methods... or use IDE to generate all delegate methods
    // ...


}

public class StringDecorator {

    public static void main(String[] args) {
        MyDigitString str1 = new MyDigitString("2gg09.6wer7656");
        System.out.println(str1 + " length is " + str1.length());
    }
}
