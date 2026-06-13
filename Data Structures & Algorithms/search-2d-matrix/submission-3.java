class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

            int L = 0;
            int R = (matrix.length * matrix[0].length) - 1;

            while (L <= R) {
                
                int mid = (L + R) / 2;
                int row = mid / matrix[0].length;
                int col = mid % matrix[0].length;

                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        return false;
    }
}