class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] p : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(p);
            } else {
                int distP = p[0] * p[0] + p[1] * p[1];
                int[] top = maxHeap.peek();
                int distTop = top[0] * top[0] + top[1] * top[1];
                if (distP < distTop) {
                    maxHeap.poll();
                    maxHeap.offer(p);
                }
            }
        }
        int[][] result = new int[k][];
        for (int i = 0 ; i < k ; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
