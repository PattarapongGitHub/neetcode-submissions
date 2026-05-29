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
        int i = 0;

        while (i < str.length()) {
            // 1. หาตำแหน่งของ '#' ตัวถัดไป โดยเริ่มหาตั้งแต่ตำแหน่ง i
            int j = str.indexOf('#', i);

            // 2. แปลงตัวเลขที่อยู่ระหว่าง i ถึง j ให้เป็นตัวเลขความยาว (Length)
            int length = Integer.parseInt(str.substring(i, j));

            // 3. ขยับตัวชี้ไปเริ่มที่ตัวอักษรแรกของข้อความจริง (หลังเครื่องหมาย #)
            i = j + 1;

            // 4. ดึงข้อความตามความยาวที่ระบุไว้
            String s = str.substring(i, i + length);
            result.add(s);

            // 5. ขยับตัวชี้ i ไปจ่อที่จุดเริ่มของก้อนถัดไป
            i += length;
        }
        return result;
    }
}
