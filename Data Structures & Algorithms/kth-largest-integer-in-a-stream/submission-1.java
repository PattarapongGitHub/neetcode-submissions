
class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (val > q.peek()) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}