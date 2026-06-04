class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        String output = "";

        // หา frequency ก่อน ของ t ไว้เทียบทีหลัง ต้องมีเจอในนี้
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                HashMap<Character, Integer> map2 = new HashMap<>();
                String c = s.substring(i, j);
                // นับความถี่
                for (int k = 0; k < c.length(); k++) {
                    char cc = c.charAt(k);
                    map2.put(cc, map2.getOrDefault(cc, 0) + 1);
                }
                // เปรียบเทียบ: นำ map2 ไปเทียบกับ map (ของ $t$) ว่ามีตัวอักษรครบถ้วนตามเงื่อนไขหรือไม่
                boolean flag = true;
                for (char cc : map.keySet()) {
                    if (!(map2.getOrDefault(cc, 0) >= map.get(cc))) {
                        flag = false;
                    }
                }
                // บันทึกคำตอบที่สั้นที่สุด: ถ้าเงื่อนไขในข้อแรกผ่าน และ Substring c รอบนี้ดันสั้นกว่า output
                // ที่เราเคยบันทึกไว้ก่อนหน้า เราก็จะเอา c ไปแทนที่ output 📏
                if (flag) {
                    if (output.equals("")) {
                        output = c;
                    } else {
                        if (output.length() >= c.length()) {
                            output = c;
                        }
                    }
                }
            }
        }
        return output;
    }
}
