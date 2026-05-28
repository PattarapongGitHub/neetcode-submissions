class Solution {

   public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int limit = 0;
        int lenUp = str.length();
        for (int i = limit; i < lenUp; i++) {
            if (limit >= lenUp) {
                break;
            }
            String numStr = "";
            int length = 0;

            for (int j = limit ; j < str.length(); j++) {
                if (str.charAt(j) == '#'){
                    length = Integer.parseInt(numStr);
                    limit++;
                    break;
                }
                numStr += str.charAt(j);
                limit++;
            }

            String numStr2 = "";
            int lim2 = limit+length;
            for (int k = limit ; k < lim2; k++) {
                numStr2 += str.charAt(k);
                limit++;
            }
            result.add(numStr2);
        }
        return result;
    }
}
