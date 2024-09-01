package array;

public class MaximumConsecutive1s {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 1, 0, 0, 1, 1, 1};
        //int result = maxConsecutiveOnes(numbers);
        int result = maxConsecutiveOnesEfficient(numbers);
        System.out.println(result);

    }

    // brute force approach
    private static int maxConsecutiveOnes(int[] no) {
        int result = 0;
        for (int i = 0; i < no.length; i++) {
            int current = 0;
            for (int j = i; j < no.length; j++) {
                if (no[j] == 1)
                    current++;
                else
                    break;
            }
            result = Math.max(current, result);
        }

        return result;
    }

    // Efficient Appraoch
    private static int maxConsecutiveOnesEfficient(int[] numbers) {
        int result = 0;
        int current = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                current = 0;
            else {
                current++;
                result = Math.max(current, result);
            }
        }
        return result;
    }

}
