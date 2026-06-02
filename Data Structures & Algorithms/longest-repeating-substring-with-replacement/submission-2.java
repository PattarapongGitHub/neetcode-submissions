class Solution {
     public int characterReplacement(String s, int k) {
        int output = 0;
        int left = 0;
        int maxFreq = 0;

        int[] counts = new int[26];
        for (int right = 0; right < s.length(); right++) {

            int charIndexR = s.charAt(right) - 'A';
            counts[charIndexR]++;

            // Find max
            maxFreq = Math.max(maxFreq, counts[charIndexR]);

            if ((right - left + 1) - maxFreq <= k) {
                output = Math.max(output, (right - left + 1));
            } else {
                int charIndexL = s.charAt(left) - 'A';
                counts[charIndexL]--;
                left++;
            }
        }
        return output;
    }
}
