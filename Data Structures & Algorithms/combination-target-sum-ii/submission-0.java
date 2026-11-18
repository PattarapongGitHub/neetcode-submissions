class Solution {
    public void helper(int[] candidates, int remaining, int startIndex, List<Integer> current,
        List<List<Integer>> result) {
        // base case
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Do this for current node.
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > remaining) {
                break;
            }
            // Child Part.
            current.add(candidates[i]);
            helper(candidates, remaining - candidates[i], i + 1, current, result);
            // BackTracking.
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
}