
class Solution {
     public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (s1.length() > s2.length()) return false;

        int[] s1_array = new int[26];
        int[] s2_array = new int[26];

        for (int i = 0; i < n1; i++) {
            s1_array[s1.charAt(i) - 'a']++;
            s2_array[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1_array, s2_array)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            s2_array[s2.charAt(i) - 'a'] ++;
            s2_array[s2.charAt(i- s1.length()) - 'a'] --;
            if (Arrays.equals(s1_array, s2_array)) {
                return true;
            }
        }

        return false;
    }
}