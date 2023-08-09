package fastAndSlowPointers;

import static java.lang.System.out;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = sumOfSquaredDigits(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }

    public static int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }

    public static void main(String args[]) {
        int[] a = {1, 5, 19, 25, 7, 789, 495, 111};
        for (int i = 0; i < a.length; i++) {
            out.println(i + 1 + "." + "\tInput Number:" + a[i]);
            out.println("\tIs Happy number " + isHappyNumber(a[i]) + "\n");
        }
    }
}
