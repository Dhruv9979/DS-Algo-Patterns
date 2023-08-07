package twopointer;

import java.util.Arrays;

import static java.lang.System.out;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                {1, 1, 2, 3, 4, 4},
                {1, 2, 3, 4, 4},
                {1, 6, 8, 10, 11, 12},
                {0, 0, 0, 0, 1, 2, 3}
        };

        for (int i = 0; i < inputs.length; i++) {
            out.println((i + 1) + ".\tArray : " + Arrays.toString(inputs[i]));
            int uniqueElements = removeDuplicates(inputs[i].clone());
            out.println("\t# of unique elements: " + uniqueElements + "\n");
        }
    }
}
