class Solution {
     public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashMap<Character, Boolean> rowMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowMap.get(board[i][j]) != null) {
                        return false;
                    } else {
                        rowMap.put(board[i][j], true);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            HashMap<Character, Boolean> colMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (colMap.get(board[j][i]) != null) {
                        return false;
                    } else {
                        colMap.put(board[j][i], true);
                    }
                }
            }
        }
        
        int[][] boxOrigins = {
                {0, 0}, {0, 3}, {0, 6}, // กล่องแถวบน
                {3, 0}, {3, 3}, {3, 6}, // กล่องแถวกลาง
                {6, 0}, {6, 3}, {6, 6} // กล่องแถวล่าง
        };

        for (int[] origin : boxOrigins) {
            
            int startRow = origin[0];
            int startCol = origin[1];

            HashMap<Character, Boolean> bothMap = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int currentRow = startRow + i;
                    int currentCol = startCol + j;
                    if (board[currentRow][currentCol] != '.') {
                        if (bothMap.get(board[currentRow][currentCol]) != null) {
                            return false;
                        } else {
                            bothMap.put(board[currentRow][currentCol], true);
                        }
                    }
                }
            }
            System.out.println(bothMap.toString());
        }
        return true;
    }
}
