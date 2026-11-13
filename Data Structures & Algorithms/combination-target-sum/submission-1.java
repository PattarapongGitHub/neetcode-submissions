class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, target, result, new ArrayList<>());
        return result;
    }
    public void helper(
        int[] nums, int startIndex, int remaining, List<List<Integer>> result, List<Integer> path) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums,i, remaining - nums[i], result, path);
            path.remove(path.size() - 1);
        }
    }
}
