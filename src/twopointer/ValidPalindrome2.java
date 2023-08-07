package twopointer;

import static java.lang.System.out;

public class ValidPalindrome2 {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindrome(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return  true;
    }
    public static void main(String[] args) {
        String[] testCase = {"PGHJHP", "ABCCBDA", "RACEACAR", "A", "ABC", "ABCEBA", "ABBABABA", "ABCDECA"};
        for (int k = 0; k < testCase.length; k++) {
            out.println("Test Case #" + (k + 1));
            out.println(new String(new char[100]).replace('\0', '-'));
            out.println("The input string is " + testCase[k] + "' and the length of the string is " + testCase[k].length() + ".");
            out.println("\nIs it a palindrome?..... " + isPalindrome(testCase[k]));
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
