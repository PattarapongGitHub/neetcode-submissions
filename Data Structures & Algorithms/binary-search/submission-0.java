class Solution {
  public int search(int[] nums, int target) {
        // ส่ง nums ต่อไปเลย ชื่อจะได้เหมือนกัน
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }

    // เอาคำว่า static ออก และเปลี่ยนชื่อจาก arr เป็น nums เพื่อความต่อเนื่อง
    private int binarySearchHelper(int[] nums, int target, int left, int right) {
        // Base Case: ขอบชนกันแล้วยังไม่เจอ
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // เจอตัวที่ตามหา
        if (nums[mid] == target) {
            return mid;
        }

        // ค้นหาในฝั่งซ้าย
        if (target < nums[mid]) {
            return binarySearchHelper(nums, target, left, mid - 1);
        }

        // ค้นหาในฝั่งขวา
        return binarySearchHelper(nums, target, mid + 1, right);
    }
}
