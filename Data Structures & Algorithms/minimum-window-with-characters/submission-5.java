class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        // หา frequency ก่อน ของ t ไว้เทียบทีหลัง ต้องมีเจอในนี้
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int matchCount = 0;
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Add c ใหม่เข้า windowMap
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // 🎯 เช็กเฉพาะตัวอักษรที่อยู่ใน t (มีอยู่ใน targetMap) เท่านั้น
            if (targetMap.containsKey(c)) {
                // เช็กว่าตัวอักษรในหน้าต่างครบตามเกณฑ์หรือยัง ถ้าครบให้เพิ่ม matchCount
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    matchCount++;
                }
            }

            // ใช้ while loop ตรวจสอบตราบใดที่ matchCount == ชนิดตัวอักษรทั้งหมดใน t (Valid):
            while (matchCount == targetMap.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }
                char cc = s.charAt(left);
                windowMap.put(cc, windowMap.getOrDefault(cc, 0) - 1);
                left++;
                if (targetMap.containsKey(cc)) {
                    if (windowMap.getOrDefault(cc, 0) < targetMap.get(cc)) {
                        matchCount--;
                    }
                }
            }
        }

        // ขยาย ขวา จนเท่ากับ s = expand
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIdx, startIdx + minLen);
    }
}
