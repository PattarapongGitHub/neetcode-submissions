class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                List<String> map2 = new ArrayList<>();
                map2.add(strs[i]);
                map.put(sorted, map2);
            } else {
                List<String> map3 = map.get(sorted);
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