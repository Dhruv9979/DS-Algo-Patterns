package slidingwindow;

import java.util.*;

import static java.lang.System.out;

public class RepeatedDNASequences {
    public static Set<String> findRepeatedSequences(String s, int k) {
        HashSet<String> repeatedSequences = new HashSet<>();
        if(s.length() < k * 2) return repeatedSequences;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while(i < s.length() - k) {
            String sequence = s.substring(i, i + k);
            if(map.containsKey(sequence)) {
                repeatedSequences.add(sequence);
            }
            map.put(sequence, map.getOrDefault(sequence, 0) + 1);
            i++;
        }
        return repeatedSequences;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) +
                    "\n\tRepeated sequences: " + findRepeatedSequences(inputsString.get(i), inputsK.get(i)) + "\n");
        }
    }
}
