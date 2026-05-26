class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[][] frequencyArray = new int[nums.length][2];

        // นับก่อน
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                int newnum = hashMap.get(num) + 1;
                hashMap.put(num, newnum);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int freq = hashMap.get(nums[i]);
            frequencyArray[i][0] = currentNum;
            frequencyArray[i][1] = freq;
        }

        Arrays.sort(frequencyArray, (a, b) -> b[1] - a[1]);

        HashSet<Integer> cars = new HashSet<>();
        int kk = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            int key = frequencyArray[i][0];
            if (!cars.contains(key) && kk < k) {
                output[kk] = key;
                kk++;
            }
            cars.add(key);
        }

        System.out.println(cars.toString());
        return output;
    }
}
