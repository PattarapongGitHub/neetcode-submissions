class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[(nums.length - k) + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && (nums[deque.peekLast()] < nums[i])) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
