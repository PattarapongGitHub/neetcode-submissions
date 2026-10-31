class Solution {
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> current, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        current.add(nums[i]);
        helper(nums, result, current, i + 1);
        current.remove(current.size() - 1);
        helper(nums, result, current, i + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), 0);
        return result;
    }
}
