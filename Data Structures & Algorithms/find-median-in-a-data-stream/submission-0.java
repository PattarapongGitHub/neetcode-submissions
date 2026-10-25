class MedianFinder {

    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (left.size() - right.size() > 1) {
            int maxleft = left.poll();
            right.offer(maxleft);
        } else if (right.size() - left.size() > 1) {
            int minright = right.poll();
            left.offer(minright);
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0; 
        }
    }
}