package com.example.patterns.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Use ranges here instead of having a separate variable for every char.
 * Comes more powerful when there are more ways to 'modify' text, like underline, bold etc
 */

class EncryptableText {

    public class Range {
        private int start;
        private int end;

        public Range(final int pStart, final int pEnd) {
            start = pStart;
            end = pEnd;
        }

        public boolean isInRange(final int pIndex) {
            return (pIndex >= start && pIndex <= end);
        }
    }

    private String text;
    private List<Range> encryptedRanges = new ArrayList<>();

    public EncryptableText(final String pWholeText) {
        text = pWholeText;
    }

    public void encryptSelection(final int pStart, final int pEnd) {
        Range range = new Range(pStart, pEnd);
        encryptedRanges.add(range);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        final int len = text.length();
        for (int i = 0; i < len; i++) {
            boolean charWritten = false;
            for (Range range : encryptedRanges) {
                if (range.isInRange(i)) {
                    sb.append("*");
                    charWritten = true;
                    continue;
                }
            }
            if (!charWritten) {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }
}

public class FlyWeightTextFormatter {

    public static void main(String[] args) {
        String str = "my password = 43zz3 previous was p4ssw0rd.";
        EncryptableText e = new EncryptableText(str);
        e.encryptSelection(14, 18);
        e.encryptSelection(33, 40);
        System.out.println(e);
    }
}
