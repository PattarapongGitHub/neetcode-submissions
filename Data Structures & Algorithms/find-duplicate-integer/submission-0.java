class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        boolean firstTime = true;

        while (slow != fast || firstTime) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            firstTime = false;
        }

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
