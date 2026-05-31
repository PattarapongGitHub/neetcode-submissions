class Solution {
     public int maxArea(int[] heights) {

        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int area = (right-left) * Math.min(heights[left], heights[right]);
            if (area > max) {
                max = area;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
