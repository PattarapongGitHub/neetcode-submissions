class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[(nums.length - k) + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }
}
