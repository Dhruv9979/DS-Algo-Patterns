package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class FruitsIntoBasket {
    public static int totalFruits(int[] fruits) {
        int windowStart = 0;
        int windowEnd = 0;
        int fruitsPicked = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (windowEnd < fruits.length) {
            int right = fruits[windowEnd];
            map.put(right, map.getOrDefault(right, 0) + 1);
            while(map.size() > 2) {
                int left = fruits[windowStart++];
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0) map.remove(left);
            }
            fruitsPicked = Math.max(fruitsPicked, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return fruitsPicked;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 1},
                {0, 1, 2, 2},
                {1, 2, 3, 2, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            out.println((i + 1) + ".\tFruits: " + Arrays.toString(inputs[i]));
            int fruits = totalFruits(inputs[i].clone());
            out.println("\tWe can pick fruits from " + fruits + " trees." + "\n");
        }
    }
}
