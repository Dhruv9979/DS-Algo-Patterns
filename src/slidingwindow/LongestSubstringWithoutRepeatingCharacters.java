package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        if(str == null || str.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd < str.length()) {
            Character right = str.charAt(windowEnd);
            if(map.containsKey(right)) {
                windowStart = Math.max(windowStart, map.get(right) + 1);
            }
            map.put(right, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("abcabcbb", "bbbbb", "pwwkew", "aabccbb", "abbbb", "abcdccbb");

        for (int i = 0; i < inputsString.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputsString.get(i));
            out.println("Length of longest substring is: " + lengthOfLongestSubstring(inputsString.get(i)));
        }
    }
}
