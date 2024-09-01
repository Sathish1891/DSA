package array;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 8, 30, -5, 20, 7};
        int k = 3;
        // int res = maxSumOfK(arr, k);
        int res = slidingWindow(arr, k);
        System.out.println(res);
    }

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
}
