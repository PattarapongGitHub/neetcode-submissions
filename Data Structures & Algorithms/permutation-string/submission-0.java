
class Solution {
    public String sort(String words) {
        char[] chars = words.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public boolean checkInclusion(String s1, String s2) {
        String sortedS1 = sort(s1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String subStringS2 = s2.substring(i, i + s1.length());
            String sortedS2 = sort(subStringS2);
            if (sortedS1.equals(sortedS2)) {
                return true;
            }
        }
        return false;
    }
}