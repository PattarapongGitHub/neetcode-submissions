class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i ++) {
            int difference = target - nums[i];

            if (hash.containsKey(difference)) {
                output[0] = hash.get(difference);
                output[1] = i;
                return output;
            } else {
                hash.put(nums[i],i);
            }
        }

        return output;

    }
}

