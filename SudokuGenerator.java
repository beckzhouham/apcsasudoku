import java.util.*;

public class MyProgram {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board[r][c] = (r * 3 + r / 3 + c) % 9 + 1;
            }
        }
        
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums);
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int oldVal = board[r][c];
                board[r][c] = nums.get(oldVal - 1);
            }
        }
        printBoard(board);
    }

    public static boolean isFullBoardValid(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(board, i) || !isColumnValid(board, i))
                return false;
        }
        
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!isBoxValid(board, r, c)) return false;
            }
        }
        return true;
    }

    public static boolean isRowValid(int[][] board, int row) {
        ArrayList<Integer> seen = new ArrayList<>();
        for (int col = 0; col < 9; col++) {
            int val = board[row][col];
            if (val != 0) {
                if (seen.contains(val)) return false;
                seen.add(val);
            }
        }
        return true;
    }

    public static boolean isColumnValid(int[][] board, int col) {
        ArrayList<Integer> seen = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            int val = board[row][col];
            if (val != 0) {
                if (seen.contains(val)) return false;
                seen.add(val);
            }
        }
        return true;
    }

    public static boolean isBoxValid(int[][] board, int startRow, int startCol) {
        ArrayList<Integer> seen = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int val = board[startRow + r][startCol + c];
                if (val != 0) {
                    if (seen.contains(val)) return false;
                    seen.add(val);
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        String horizontalBorder = "+-------+-------+-------+";
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) System.out.println(horizontalBorder);
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) System.out.print("| ");
                System.out.print(board[r][c] + " ");
                if (c == 8) System.out.print("|");
            }
            System.out.println();
        }
        System.out.println(horizontalBorder);
    }
}
