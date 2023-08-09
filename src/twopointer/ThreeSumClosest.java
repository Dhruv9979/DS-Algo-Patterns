package twopointer;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(closestSum - target) > Math.abs((sum - target))) closestSum = sum;
                if(sum > target) right--;
                if(sum < target) left++;
                if(sum == target) break;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[][] numsList = {{-1, 2, 1, -4},
                {4, 0, 5, -5, 3, 3, 0, -4, -5},
                {-1, 2, 0, 1, -3, -5}};

        int[] targetList = {1, 1, 1};

        for (int i = 0; i < targetList.length; i++) {
            out.println((i + 1) + ".\tArray: " + Arrays.toString(numsList[i]));
            out.println("Closest Sum is: " + threeSumClosest(numsList[i], targetList[i]) + "\n");
        }
    }
}
