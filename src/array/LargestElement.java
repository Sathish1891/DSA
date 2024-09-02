package array;

public class LargestElement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 7, 9, 6, 8};
        int largestNumber = findSecondLargestNo(numbers);
        System.out.println("Second Largest Number is : " + largestNumber);
    }

    private static int findSecondLargestNo(int[] nums) {
        int largestNo = nums[0];
        int secondLargestNo = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestNo) {
                secondLargestNo = largestNo;
                largestNo = nums[i];

            } else if (nums[i] > secondLargestNo && nums[i] != largestNo) {

                secondLargestNo = nums[i];
            }
        }
        return secondLargestNo;
    }
}
