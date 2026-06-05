class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[(nums.length - k) + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < nums.length; i++) {
            int [] max = new int [2];
            max[0] = nums[i];
            max[1] = i;
            maxHeap.add(max);
            int range = i-k+1;
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < range) {
                maxHeap.poll();
            }

            if (i >= k-1){
                result[i-k+1] = maxHeap.peek()[0];
            }
        }
        return result;
    }
}
