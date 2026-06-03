
class Solution {
     public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1_array = new int[26];
        int[] s2_array = new int[26];

        for (int i = 0; i < n1; i++) {
            s1_array[s1.charAt(i) - 'a']++;
            s2_array[s2.charAt(i) - 'a']++;
        }
        //หลังจากส่วนบนทำงานเสร็จเราจะได้ชุดเริ่มต้นแล้ว

        //เดาว่าน่าจะเป็น equal operation ครั้งแรกที่นี้โดยใช้ matching system
        int matched = 0;
        for (int i = 0; i < 26; i++) {
            if (s1_array[i] == s2_array[i]) {
                matched++;
            }
        }

        if (matched == 26){
            return true;
        }

        //ขยับซ้าย ขวา
        for (int i = n1; i < n2; i++) {
            int i1 = s2.charAt(i - n1) - 'a';
            if (s1_array[i1] == s2_array[i1]) {
                matched--;
            }
            s2_array[i1] --;

            if (s1_array[i1] == s2_array[i1]) {
                matched++;
            }

            int i2 = s2.charAt(i) - 'a';
            if (s1_array[i2] == s2_array[i2]) {
                matched--;
            }
            s2_array[i2] ++;
            if (s1_array[i2] == s2_array[i2]) {
                matched++;
            }
            if (matched == 26){
                return true;
            }
        }
        return false;
    }
}