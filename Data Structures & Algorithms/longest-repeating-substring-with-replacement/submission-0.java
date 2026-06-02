class Solution {
 public int characterReplacement(String s, int k) {

        int output = 0;
        
        for (int i = 0 ; i < s.length() ; i++) {
            int[] counts = new int[26];
            for (int j = i ; j < s.length() ; j++) {
                int index = s.charAt(j) - 'A';
                counts[index]++;
                //Find max
                int max = 0;
                for (int l = 0 ; l < counts.length ; l++) {
                    if (counts[l] > max) {
                        max = counts[l];
                    }
                }
                if ((j - i + 1) - max <= k) {
                    output = Math.max(output, (j - i + 1));
                } else  {
                    break;
                }
            }
        }
        return output;
    }
}
