package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public static int longestKSubstring(String str, int k) {
        if(str == null || str.length() == 0 || k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd < str.length()) {
            Character right = str.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while(map.size() > k) {
                Character left = str.charAt(windowStart++);
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0) map.remove(left);
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("araaci", "araaci", "aabbcc", "aabbcc");
        List<Integer> inputsK = Arrays.asList(2, 1, 1, 2);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) +
                    "\n\n\tLength of longest substring is: " + longestKSubstring(inputsString.get(i), inputsK.get(i)));
        }
    }
}
