class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        // q.add(new int[]{จำนวนที่เหลือ, เวลาที่พร้อม});
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Freq count
        for (char t : tasks) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }

        // เอาทุกตัวใน count ใส่ใน maxHeap
        for (Integer t : count.values()) {
            maxHeap.offer(t);
        }

        int time = 0;

        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll() - 1;
                if (task > 0) {
                    q.add(new int[] {task, n + time});
                }
            }
            if (!q.isEmpty()) {
                int[] temp = q.peek();
                if (temp[1] == time) {
                    int[] temp2 = q.poll();
                    int task = temp2[0];
                    maxHeap.offer(task);
                }
            }
        }
        return time;
    }
}
