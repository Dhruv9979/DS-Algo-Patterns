package twopointer;

import static java.lang.System.out;

public class ReverseWords {
    public static String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        String s2 = cleanSpaces(s1, s1.length);
        StringBuilder builder = new StringBuilder(s2);
        reverse(builder, 0, builder.length() - 1);
        int n = builder.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && builder.charAt(end) != ' ')
                ++end;
            reverse(builder, start, end - 1);
            start = end + 1;
            ++end;
        }
        return builder.toString();
    }

    public static void reverse(StringBuilder word, int start, int end) {
        while (start < end) {
            char temp = word.charAt(start);
            word.setCharAt(start++, word.charAt(end));
            word.setCharAt(end--, temp);
        }
    }

    static String cleanSpaces(char[] a, int n) {
        String str = new String(a, 0, n);
        str = str.replaceAll("\\s+", " ").trim();
        return str;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "Hello World", "We love Python",
                "The quick brown fox jumped over the lazy dog.",
                "Hey", "To be or not to be", "AAAAA", " Hello     World "};

        for (int i = 0; i < inputs.length; i++) {
            out.print(i + 1);
            out.println(".\tActual string:\t\t" + inputs[i]);
            out.println("\tReversed String:\t" + reverseWords(inputs[i]));
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
