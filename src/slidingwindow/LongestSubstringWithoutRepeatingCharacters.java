package slidingwindow;

import java.util.*;

import static java.lang.System.out;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        if(str == null || str.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int windowStart = 0;
        int windowEnd = 0;
        int max = 0;
        while(windowEnd < str.length()) {
            if(!set.contains(str.charAt(windowEnd))) {
                set.add(str.charAt(windowEnd++));
                max = Math.max(max, set.size());
            } else
                set.remove(str.charAt(windowStart++));
        }
        return max;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("abcabcbb", "bbbbb", "pwwkew", "aabccbb", "abbbb", "abcdccbb");

        for (int i = 0; i < inputsString.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputsString.get(i));
            out.println("Length of longest substring is: " + lengthOfLongestSubstring(inputsString.get(i)));
        }
    }
}
