class Solution {
public int minEatingSpeed(int[] piles, int h) {
        int output = 0;
        // สมมติให้ตัวแรกเป็น max ก่อน
        int max = piles[0];

        // วนลูปเทียบทุกตัวใน Array
        for (int num : piles) {
            if (num > max) {
                max = num; // เจอตัวใหญ่กว่า ให้เปลี่ยนมาจำตัวนี้แทน
            }
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            //เอามาหารกันเฉยๆ แล้วปัดเศษขึ้นโดยการใช้สูตรคณิตศาสตร์
            int k = 0;
            for (int num : piles) {
                k += (num + mid - 1) / mid;
            }

            if (k <= h) {
                output = mid;
                right = mid - 1;
            } else {
                left = mid + 1 ;
            }
        }
        return output;
    }
}
