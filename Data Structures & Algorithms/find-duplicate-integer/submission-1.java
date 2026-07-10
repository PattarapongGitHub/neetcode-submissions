class Solution {
    public int findDuplicate(int[] nums) {
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                output = Math.abs(nums[i]);
                break;
            } else {
                nums[index] *= -1;
            }
        }
        return output;
    }
}
