class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> fleets = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = 0;
            if (i != heights.length) {
                currentHeight = heights[i];
            }
            while (!fleets.isEmpty() && currentHeight <= heights[fleets.peek()]) {
                int h_index = fleets.pop();
                int width = 0;
                if (fleets.isEmpty()) {
                    width = i;
                } else {
                    width = i - fleets.peek() - 1;
                }
                int area = heights[h_index] * width;
                maxArea = Math.max(maxArea, area);
            }
            fleets.push(i);
        }
        return maxArea;
    }
}