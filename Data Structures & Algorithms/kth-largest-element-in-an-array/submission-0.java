class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        for (int p : nums) {
            if (minH.size() < k) {
                minH.offer(p);
            } else {
                if (p > minH.peek()) {
                    minH.poll();
                    minH.offer(p);
                }
            }
        }
        return minH.peek();
    }
}
