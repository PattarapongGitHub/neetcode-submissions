class Solution {
    public int lengthOfLongestSubstring(String s) {
        int output = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
            }
            output = Math.max(output, set.size());
        }
        return output;
    }
}