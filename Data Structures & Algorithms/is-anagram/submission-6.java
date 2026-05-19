
class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<String, Integer> stringsT = new HashMap<>();
        HashMap<String, Integer> stringsC = new HashMap<>();

        for (int i = 0 ; i < s.length() ; i ++) {
            String c = s.charAt(i) + "";
            if (stringsT.containsKey(c)) {
                int c2 = stringsT.get(c);
                stringsT.put(c, c2 + 1);
            } else {
                stringsT.put(c, 1);
            }
        }

        System.out.println(stringsT.toString());

        for (int j = 0 ; j < t.length() ; j ++) {
            String cc = t.charAt(j) + "";
            if (stringsC.containsKey(cc)) {
                int c2 = stringsC.get(cc);
                stringsC.put(cc, c2 + 1);
            } else {
                stringsC.put(cc, 1);
            }
        }

        System.out.println(stringsC.toString());

        for (int j = 0 ; j < t.length() ; j ++) {
            String cc = t.charAt(j) + "";
            if (stringsC.containsKey(cc) && stringsT.containsKey(cc)) {
                int c1 = stringsT.get(cc);
                int c2 = stringsC.get(cc);
                if (c1 != c2) {
                    return false;
                }
            }  else {
                return false;
            }
        }

        return true;
    }
}
