class Solution {
    
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backTrackWordSearch(0, row, col, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrackWordSearch(int index, int row, int col, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char currChar = board[row][col];
        board[row][col] = '#';
        boolean found = backTrackWordSearch(index + 1, row + 1, col, board, word)
                || backTrackWordSearch(index + 1, row - 1, col, board, word)
                || backTrackWordSearch(index + 1, row, col + 1, board, word)
                || backTrackWordSearch(index + 1, row, col - 1, board, word);
        board[row][col] = currChar;
        return found;
    }

}
