class Solution {
     public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (current != '.') {
                    if (rows[i].contains(current)) {
                        return false;
                    } else if (cols[j].contains(current)) {
                        return false;
                    } else if (boxes[boxIndex].contains(current)) {
                        return false;
                    } else {
                        rows[i].add(current);
                        cols[j].add(current);
                        boxes[boxIndex].add(current);
                    }
                }
            }
        }
        return true;
    }
}
