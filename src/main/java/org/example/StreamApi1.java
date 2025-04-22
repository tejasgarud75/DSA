package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StreamApi1 {

    public static void main(String[] args) {

        int nums[] = {3, 2, 3};
        int target = 6;
        int i[] = twoSum(nums, target);
        Arrays.stream(i).forEach(j -> System.out.println(j));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

