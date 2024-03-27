package fastandslowpointers;

import java.util.Arrays;

import static java.lang.System.out;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int meet = 2;
        int slow = 0, fast = 0;
        while (meet > 0) {
            if (slow == nums.length - 1) {
                slow = 0;
                out.println("If Slow: " + slow);
            } else  {
                slow++;
                out.println("Else Slow: " + slow);
            }
            if (fast == nums.length - 2) {
                fast = 0;
                out.println(" - 2 Fast: " + fast);
            } else if (fast == nums.length - 1) {
                fast = 1;
                out.println("- 1 Fast: " + fast);
            } else {
                fast += 2;
                out.println("Else Fast: " + fast);
            }
            if (slow == fast) {
                meet--;
                slow = 0;
                out.println("Num equals Fast: " + fast);
            }
        }
        return fast;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2},
                {1, 3, 6, 2, 7, 3, 5, 4}
        };
        for (int i = 0; i < nums.length; i++) {
            out.print(i + 1);
            out.println(".\tnums = " + Arrays.toString(nums[i]));
            out.println("\tDuplicate number = " + findDuplicate(nums[i]));
            out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
