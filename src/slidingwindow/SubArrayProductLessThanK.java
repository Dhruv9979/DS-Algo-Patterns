package slidingwindow;

import java.util.Arrays;

import static java.lang.System.out;

public class SubArrayProductLessThanK {
    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = 1;
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd < nums.length) {
            product *= nums[windowEnd];
            while(product >= k) {
                product /= nums[windowStart];
                windowStart++;
            }
            count += windowEnd - windowStart + 1;
            windowEnd++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] numsList = {{10, 5, 2, 6},
                {1, 2, 3}};

        int[] targetList = {100, 0};

        for (int i = 0; i < targetList.length; i++) {
            out.println((i + 1) + ".\tArray: " + Arrays.toString(numsList[i]));
            out.println("Closest Sum is: " + numSubArrayProductLessThanK(numsList[i], targetList[i]) + "\n");
        }
    }
}
