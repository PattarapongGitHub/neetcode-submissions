class Solution {
    public int trap(int[] height) {
        int output = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeftHeight = 0;
            int maxLindex = 0;
            for (int j = i; j >= 0; j--) {
                if (height[j] > maxLeftHeight) {
                    maxLeftHeight = height[j];
                    maxLindex = j;
                }
            }
            int maxRightHeight = 0;
            int maxRindex = 0;
            for (int k = i; k < height.length; k++) {
                if (height[k] > maxRightHeight) {
                    maxRightHeight = height[k];
                    maxRindex = k;
                }
            }
            int upBound = Math.min(maxLeftHeight, maxRightHeight);
            int tapping = Math.max(0, upBound - height[i]);
            output += tapping;
        }

        return output;
    }
}
