package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length() || t.length() == 0) return "";
        if (s.equals(t)) return s;

        int windowStart = 0;
        int windowEnd = 0;
        int minLength = s.length();
        int minStart = 0;
        int minEnd = 0;
        boolean flag = false;

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        int count = t.length();

        while (windowEnd < s.length()) {
            char right = s.charAt(windowEnd);
            if (mapT.containsKey(right)) {
                mapT.put(right, mapT.get(right) - 1);
                if (mapT.get(right) >= 0) count--;
            }
            while (count == 0 && windowStart <= windowEnd) {
                flag = true;
                int currentMinLength = windowEnd - windowStart + 1;
                if (currentMinLength <= minLength) {
                    minLength = currentMinLength;
                    minStart = windowStart;
                    minEnd = windowEnd;
                }
                char left = s.charAt(windowStart);
                if (mapT.containsKey(left)) {
                    mapT.put(left, mapT.get(left) + 1);
                    if (mapT.get(left) > 0) count++;
                }
                windowStart++;
            }
            windowEnd++;
        }
        return flag ? s.substring(minStart, minEnd + 1) : "";
    }

    public static void main(String[] args) {
        List<String> inputS = Arrays.asList("ADOBECODEBANC", "a", "a");
        List<String> inputT = Arrays.asList("ABC", "a", "aa");

        for (int i = 0; i < inputS.size(); i++) {
            out.println((i + 1) + ".\tInput S: " + inputS.get(i));
            out.println("\tT: " + inputT.get(i));
            out.println("\tMinimum window substring is: " + minWindow(inputS.get(i), inputT.get(i)) + "\n");
        }
    }
}
