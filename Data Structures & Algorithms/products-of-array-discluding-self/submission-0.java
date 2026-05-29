class Solution {
 public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int intermediate = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    intermediate *= nums[j];
                }
            }
            output[i] = intermediate;
        }
        return  output;
    }
}  
