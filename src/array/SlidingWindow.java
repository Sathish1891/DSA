package array;

import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        // int res = maxSumOfK(arr, k);
        //int res = slidingWindow(arr, k);
        int res = maximumSubarraySum(arr, k);
        System.out.println(res);
    }

    // Sliding window approach
    private static int slidingWindow(int[] arr, int k) {
        int result = 0;
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += arr[i];
            result = current;
        }
        for (int i = k; i < arr.length; i++) {
            current = current + arr[i] - arr[i - k];
            result = Math.max(current, result);
        }
        return result;
    }

    // brute force approach
    private static int maxSumOfK(int[] arr, int k) {
        int maxCount = 0;


        for (int i = 0; i < k; i++) {
            int current = 0;
            for (int j = 0; j < k; j++) {
                current += arr[i + j];
                maxCount = Math.max(current, maxCount);
            }

        }
        return maxCount;
    }

    // maximum sum of distinct subarray with length k

    public static int maximumSubarraySum(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the window
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];

            // If the window size exceeds k, adjust the window from the left (remove the leftmost element)
            if (i >= k) {
                int leftElement = nums[i - k];
                map.put(leftElement, map.get(leftElement) - 1);
                if (map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }
                currentSum -= leftElement;
            }

            // Check if the current window has exactly k distinct elements
            if (map.size() == k) {
                result = Math.max(result, currentSum);
            }
        }

        return result;
    }
}
