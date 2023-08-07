package twopointer;

import java.util.Arrays;

import static java.lang.System.*;

public class SortColors {
    public static int[] sortColors (int[] colors) {
        int start = 0;
        int end = colors.length - 1;
        int index = 0;
        
        while(index <= end) {
            if(colors[index] == 0) {
                colors[index] = colors[start];
                colors[start] = 0;
                start++;
                index++;
            } else if(colors[index] == 2) {
                colors[index] = colors[end];
                colors[end] = 2;
                end--;
            } else {
                index++;
            }
        }
        return colors;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));
            int[] sortedColors = sortColors(inputs[i].clone());
            out.println("\tThe sorted array is: " + Arrays.toString(sortedColors) + '\n');
        }
    }
}
