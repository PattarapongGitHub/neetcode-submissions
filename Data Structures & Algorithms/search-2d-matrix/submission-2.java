class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0 ; row < matrix.length ; row ++) {

            int L = 0;
            int R = matrix[0].length - 1;

            while (L <= R) {
                int mid = (L + R) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }

        return false;
    }
}