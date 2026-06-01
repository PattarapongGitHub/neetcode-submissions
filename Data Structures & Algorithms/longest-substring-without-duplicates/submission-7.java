class Solution {
    public int lengthOfLongestSubstring(String s) {
        int output = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (hashMap.containsKey(c)) {
                int indexLeft = hashMap.get(c);
                left = Math.max(left, indexLeft + 1);
            }

            hashMap.put(c, right);

            output = Math.max(output, right - left + 1);
        }
        return output;
    }
}