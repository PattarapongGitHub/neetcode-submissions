
class Solution {
    public int[] counts(int[] s, String ss, int start, int end) {
        for (int i = start; i < end; i++) {
            int temp = ss.charAt(i) - 'a';
            s[temp]++;
        }
        return s;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1_array = new int[26];
        s1_array = counts(s1_array, s1, 0, s1.length());

        int[] s2_array = new int[26];
        s2_array = counts(s2_array, s2, 0, s1.length());

        if (Arrays.equals(s1_array, s2_array)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            int tempR = s2.charAt(i) - 'a';
            s2_array[tempR]++;
            int tempL = s2.charAt(i - s1.length()) - 'a';
            s2_array[tempL]--;
            if (Arrays.equals(s1_array, s2_array)) {
                return true;
            }
        }

        return false;
    }
}