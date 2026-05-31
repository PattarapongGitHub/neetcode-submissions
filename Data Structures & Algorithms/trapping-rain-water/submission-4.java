class Solution {
    
   public int trap(int[] height) {

        int output = 0;

        //Prefix Maximum
        int[] prefixMax = new int[height.length];
        prefixMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefixMax[i] = Math.max(height[i], prefixMax[i - 1]);
        }

        //Suffix Maximum
        int[] suffixMax = new int[height.length];
        suffixMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            output += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return output;
    }
}
