package slidingwindow;

import java.util.Arrays;

import static java.lang.System.out;

public class MaxConsecutiveOnesIII {
    //Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int zeroCount = 0;
        while (windowEnd < nums.length) {
            if(nums[windowEnd] == 0) zeroCount++;
            while(zeroCount > k) {
                if(nums[windowStart] == 0) {
                    zeroCount--;
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[][] numsList = {{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0 ,0, 0, 0}};

        int[] flipList = {2, 3};

        for (int i = 0; i < flipList.length; i++) {
            out.println((i + 1) + ".\tArray: " + Arrays.toString(numsList[i]));
            out.println("Longest subarray is: " + longestOnes(numsList[i], flipList[i]) + "\n");
        }
    }
}
