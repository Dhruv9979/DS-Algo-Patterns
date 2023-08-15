package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxLen = 0;
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(windowEnd < s.length()){
            Character right = s.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            maxCount = Math.max(maxCount, map.get(right));
            while(windowEnd - windowStart - maxCount + 1 > k) {
                Character left = s.charAt(windowStart);
                map.put(left, map.get(left) - 1);
                windowStart++;
            }
            maxLen = windowEnd - windowStart + 1;
            windowEnd++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ABAB", "AABABBA");
        List<Integer> inputsK = Arrays.asList(2, 1);

        for (int i = 0; i < inputsK.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) +
                    "\n\tLongest Substring length: " + characterReplacement(inputsString.get(i), inputsK.get(i)) + "\n");
        }
    }
}
