
class Solution {
    public boolean hasDuplicate(int[] nums) {
       
        HashMap<Integer, Integer> scores = new HashMap<>();
        
        for (int i = 0 ; i < nums.length ; i ++) { // 1. แก้จาก lenght เป็น length
            if (scores.containsKey(nums[i])){
                return true;
            }
            scores.put(nums[i], 1); // 2. แก้ตรงนี้ HashMap ต้องใส่ทั้ง Key และ Value (เช่น 1 หรือ i)
        }
        return false;
    }
}