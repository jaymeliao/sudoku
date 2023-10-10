//recursion backtracking 
import java.util.*;
import java.io.*;
public class Main {
    public static int[][] sudoBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    public static void printBoard() {
        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + sudoBoard[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("\n  \n" );
    }
  
    public static boolean setSudoBoard( ){
      printBoard();
      for (int row = 0; row< 9 ; row++){
        for (int col = 0 ; col<9 ; col++){
          if (sudoBoard[row][col] ==0){
            for (int i = 1; i<=9; i++){
              if (isValid(i, row , col)){
                sudoBoard[row][col] = i;
                if (setSudoBoard()) return true;
                sudoBoard[row][col] = 0;
              }
            }
            return false;
          }
        }
      }
      return true;   
    }

    public static boolean isValid(int number, int row, int column){
        int rowMin, rowMax;
        int columnMin, columnMax;
        for (int i = 0; i < 9; i++) {
            if(sudoBoard[row][i] == number) return false;
        }
        for (int i = 0; i < 9; i++) {
            if(sudoBoard[i][column] == number) return false;
        }
        rowMin = (row/3) * 3;
        rowMax = rowMin + 3;
        columnMin = (column/3) * 3;
        columnMax = columnMin + 3;
        for (int i = rowMin; i < rowMax; i++) {
            for (int j = columnMin; j < columnMax; j++) {
                if(sudoBoard[i][j] == number) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        setSudoBoard();
        printBoard();
    }
}
