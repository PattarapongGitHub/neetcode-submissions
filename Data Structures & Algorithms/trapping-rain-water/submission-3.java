class Solution {
    public int trap(int[] height) {

        int output = 0;

        //Prefix Maximum
        int[] prefixMax = new int[height.length];
        prefixMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > prefixMax[i-1]) {
                prefixMax[i] = height[i];
            } else {
                prefixMax[i] = prefixMax[i-1];
            }
        }

        //Suffix Maximum
        int[] suffixMax = new int[height.length];
        suffixMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > suffixMax[i+1]) {
                suffixMax[i] = height[i];
            } else {
                suffixMax[i] = suffixMax[i+1];
            }
        }

        for (int i = 0; i < height.length; i++) {
            output += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return output;
    }
}
