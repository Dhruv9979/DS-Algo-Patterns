package slidingwindow;

import java.util.Arrays;

import static java.lang.System.out;

public class MinimumSubArraySizeSum {
    public static int minSubArrayLen(int[] nums, int target) {
        int windowStart = 0;
        int windowSum = 0;
        int result = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            while(windowSum >= target) {
                result = Math.min(result, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[][] numsList = {{2, 3, 1, 2, 4, 3},
                {2, 1, 5, 2, 3, 2}, {2, 1, 5, 2, 8},
                {1, 4, 4}, {1, 1, 1, 1, 1, 1, 1, 1}};

        int[] targetList = {7, 7, 7, 4, 11};

        for (int i = 0; i < targetList.length; i++) {
            out.println((i + 1) + ".\tArray: " + Arrays.toString(numsList[i]));
            out.println("Minimum Sub Array Size is: " + minSubArrayLen(numsList[i], targetList[i]) + "\n");
        }
    }
}
