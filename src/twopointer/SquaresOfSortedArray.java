package twopointer;

import java.util.Arrays;

import static java.lang.System.out;

public class SquaresOfSortedArray {
    public static int[] squares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[right]) > Math.abs(nums[left])) {
                ans[i] = nums[right] * nums[right--];
            } else {
                ans[i] = nums[left] * nums[left++];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {-4, -1, 0, 3, 10},
                {-7, -3, 2, 3, 11}
        };

        for (int i = 0; i < inputs.length; i++) {
            out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            int[] squared = squares(inputs[i].clone());
            out.println("\tThe squared array is: " + Arrays.toString(squared) + "\n");
        }
    }
}
