class Solution {
public int longestConsecutive(int[] nums) {

        int output = 0;

        HashSet<Integer> sets = new HashSet<>();

        for (int num : nums) {
            sets.add(num);
        }

        for (int set : sets) {
            if (!sets.contains(set - 1)) {
                int currentNum = set;
                int currentStreak = 1;
                while (sets.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                output = Math.max(output, currentStreak);
            }
        }

        return output;
    }
}
