class Solution {
   public int lengthOfLongestSubstring(String s) {

        int output = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int intermediate = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    intermediate ++;
                } else {
                    break;
                }
            }
            output = Math.max(output, intermediate);
        }
        return output;
    }
}