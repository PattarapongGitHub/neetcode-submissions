class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            String str1 = strs[i];

            int[] counts = new int[26];
            for (char c : str1.toCharArray()) {
                counts[c - 'a']++;
            }

            String key = "";
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] > 0) {
                    char letter = (char) (j + 'a');
                    key += String.valueOf(letter) + counts[j]; // ได้ "a"
                }
            }
            if (!map.containsKey(key)) {
                List<String> map2 = new ArrayList<>();
                map2.add(strs[i]);
                map.put(key, map2);
            } else {
                List<String> map3 = map.get(key);
                map3.add(strs[i]);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (List<String> group : map.values()) {
            output.add(group);
        }
        
        return output;
    }
}