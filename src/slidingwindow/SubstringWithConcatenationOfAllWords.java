package slidingwindow;

import java.util.*;

import static java.lang.System.out;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int wordCount = words.length;
        int wordLength = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i < s.length() - wordCount * wordLength; i++) {
            Map<String, Integer> wordSeen = new HashMap<>();
            for(int j = 0; j < wordCount; j++) {
                int wordIndex = i + j * wordLength;
                String word = s.substring(wordIndex, wordIndex + wordLength);
                if (!wordMap.containsKey(word)) {
                    break;
                }
                wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);
                if(wordSeen.get(word) > wordMap.getOrDefault(word, 0)) {
                    break;
                }
                if(j + 1 == wordCount) result.add(i);
                }
            }
        return result;
    }

    public static void main(String[] args) {
        List<String> inputS = Arrays.asList("barfoothefoobarman", "wordgoodgoodgoodbestword", "barfoofoobarthefoobarman");
        List<String[]> words = Arrays.asList(
                new String[]{"foo", "bar"},
                new String[]{"word", "good", "best", "word"},
                new String[]{"bar", "foo", "the"}
        );
        for (int i = 0; i < inputS.size(); i++) {
            out.println((i + 1) + ".\tInput: " + inputS.get(i));
            out.println("\tWords: " + Arrays.toString(words.get(i)));
            out.println("\tStarting indices of all the concatenated substrings is: " + findSubstring(inputS.get(i), words.get(i)) + "\n");
        }
    }
}
