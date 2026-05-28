class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] output = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        // นับก่อน
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                int newnum = hashMap.get(num) + 1;
                hashMap.put(num, newnum);
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>(); // เอาถัง ArrayList เปล่าๆ ไปวางไว้ที่ชั้น i
        }

        for (int num : hashMap.keySet()) {
            int freq = hashMap.get(num);
            bucket[freq].add(num);
        }

        int kk = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (!bucket[i].isEmpty() && kk < k) {
                for (int j = 0; j < bucket[i].size() ; j++) {
                    int test = bucket[i].get(j);
                        output[kk] = test;
                        kk++;
                }
            }
        }
        return output;
    }
}