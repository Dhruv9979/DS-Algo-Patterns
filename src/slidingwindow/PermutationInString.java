package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapS2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            mapS1.put(s1.charAt(i), mapS1.getOrDefault(s1.charAt(i), 0) + 1);
            mapS2.put(s2.charAt(i), mapS2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (mapS1.equals(mapS2)) return true;
        for (int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd++) {
            int windowStart = windowEnd - s1.length();
            mapS2.put(s2.charAt(windowStart), mapS2.get(s2.charAt(windowStart)) - 1);
            if (mapS2.get(s2.charAt(windowStart)) == 0) mapS2.remove(s2.charAt(windowStart));
            mapS2.put(s2.charAt(windowEnd), mapS2.getOrDefault(s2.charAt(windowEnd), 0) + 1);
            if (mapS1.equals(mapS2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> inputS1 = Arrays.asList("ab", "ab", "adc");
        List<String> inputS2 = Arrays.asList("eidbaooo", "eidboaoo", "dcda");

        for (int i = 0; i < inputS1.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputS1.get(i) +
                    "\n\tk: " + inputS2.get(i) +
                    "\n\tLength of longest substring is: " + checkInclusion(inputS1.get(i), inputS2.get(i)) + "\n");
        }
    }
}
