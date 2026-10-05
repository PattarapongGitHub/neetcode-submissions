class Solution {
    private void heapify(int[] stones, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if ((left < n) && (stones[left] > stones[largest])) {
            largest = left;
        }
        if ((right < n) && (stones[right] > stones[largest])) {
            largest = right;
        }
        if (largest != i) {
            int temp = stones[i];
            stones[i] = stones[largest];
            stones[largest] = temp;
            heapify(stones, n, largest);
        }
    }

    public int lastStoneWeight(int[] stones) {
        int heapSize = stones.length;
        int start = (heapSize / 2) - 1;

        for (int i = start; i >= 0; i--) {
            heapify(stones, stones.length, i);
        }

        while (heapSize > 1) {
            int secondIdx = 0;
            if (heapSize == 2) {
                secondIdx = 1;
            } else if (stones[1] < stones[2]) {
                secondIdx = 2;
            } else {
                secondIdx = 1;
            }

            int diff = stones[0] - stones[secondIdx];
            if (diff == 0) {
                stones[secondIdx] = stones[heapSize - 2];
                stones[0] = stones[heapSize - 1];
                heapSize -= 2;
                heapify(stones, heapSize, secondIdx);
                heapify(stones, heapSize, 0);
            } else {
                stones[0] = diff;
                stones[secondIdx] = stones[heapSize - 1];
                heapSize--;
                heapify(stones, heapSize, secondIdx);
                heapify(stones, heapSize, 0);
            }
        }

        if (heapSize == 1) {
            return stones[0];
        } else {
            return 0;
        }
    }
}
