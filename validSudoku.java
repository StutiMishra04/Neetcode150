/*
You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

Each row must contain the digits 1-9 without duplicates.
Each column must contain the digits 1-9 without duplicates.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
Return true if the Sudoku board is valid, otherwise return false

Note: A board does not need to be full or be solvable to be valid.

Input: board = 
[["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

Output: true
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row traversal for first row of sudoku
        // 0 --> 5 3 . . 7 . . . .
        //       |.|.....|.......|
        //       i i  i  i   i   i
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }
        // since Set<Character> takes only one character, so there is no problem
        // of 24 or double digits entering 

        // For Column traversal
        // 5 --> i
        // 6 --> i
        // . --> i
        // 8 --> i
        // 4 --> i
        // 7 --> i
        // . --> i
        // . --> i
        // . --> i
        // |
        // 0th col
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        // For row = 1 --> 1 2 . 3 . . . .
        //                   0 1 2   3 4 5   6 7 8
        // 1 --> i         0|      |       |       |
        // 4 --> i    0    1|  0   |   1   |   2   |
        // . --> i         2|_ _ _ | _ _ _ | _ _ _ |
        // 5 --> i         3|      |       |       |
        // . --> i    1    4|  3   |   4   |   5   |
        // 7 --> i         5|_ _ _ | _ _ _ | _ _ _ |
        // . --> i         6|      |       |       |
        // . --> i    2    7|  6   |   7   |   8   |
        // . --> i         8|_ _ _ | _ _ _ | _ _ _ |
        // |                   0       1       2
        // j
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}

