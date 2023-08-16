package slidingwindow;

import java.util.*;

import static java.lang.System.out;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length() || p.length() == 0) return result;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(mapP.equals(mapS)) result.add(0);
        for(int windowEnd = p.length(); windowEnd < s.length(); windowEnd++) {
            int windowStart = windowEnd - p.length();
            mapS.put(s.charAt(windowStart), mapS.get(s.charAt(windowStart)) - 1);
            if(mapS.get(s.charAt(windowStart)) == 0) mapS.remove(s.charAt(windowStart));
            mapS.put(s.charAt(windowEnd), mapS.getOrDefault(s.charAt(windowEnd), 0) + 1);
            if(mapP.equals(mapS)) result.add(windowStart + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> inputS = Arrays.asList("cbaebabacd", "abab");
        List<String> inputP = Arrays.asList("abc", "ab");

        for (int i = 0; i < inputS.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputS.get(i) +
                    "\n\tk: " + inputP.get(i) +
                    "\n\tStart indices of anagram are: " + findAnagrams(inputS.get(i), inputP.get(i)) + "\n");
        }
    }
}
