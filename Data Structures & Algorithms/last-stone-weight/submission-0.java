
    class Solution {
    public int lastStoneWeight(int[] stones) {
        // 1. สร้าง Max-Heap 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 2. นำหินทั้งหมดใส่ลงใน Heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // 3. วนลูปทุบหินตราบที่ยังมีหินมากกว่า 1 ก้อน
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int diff = stone1 - stone2;
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }

        // 4. คืนค่าผลลัพธ์
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.poll();
    }
}

