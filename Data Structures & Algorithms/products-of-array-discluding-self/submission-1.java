class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] leftProducts = new int[nums.length];

        leftProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        int[] rightProducts = new int[nums.length];
        rightProducts[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            rightProducts[i - 1] = rightProducts[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }

        return output;
    }
}
