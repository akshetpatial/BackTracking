package com.akshet;

import java.util.Scanner;

public class NQueens {

    public static int boards(boolean[][] board, int row , int col) {

        if(row==board.length){
            display(board);
            return 1;
        }

        int count=0;

        for(int cl =0; cl<board[0].length; cl++) {
            if(isSafe(board,row ,cl)) {
                board[row][cl] = true;
                count += boards(board, row + 1, cl);
                // This line will be executed when one recursive call will be over.
                // Backtracking here means marking back the changes
                board[row][cl] = false;
            }
        }
        return count;
    }

    private static void display(boolean[][] board) {
        for (boolean[] booleans : board) {
            for (boolean element : booleans) {
                if (element)
                    System.out.print(" Q ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(boolean[][] board, int row , int col) {

        // Checking the top straight
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

       // No need to check right and left as they are already covered
      // checking left
       /* for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        // checking right
        for (int i = col; i < board[0].length; i++) {
            if (board[row][i]) {
                return false;
            }
        }*/

        // checking first diagonal
        int maxLeft= Math.min(row,col);
        for (int i = 1; i <=maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
        // checking Second diagonal
        int maxRight= Math.min(row,board.length-col-1);
        for (int i = 1; i <=maxRight; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the Board");
        System.out.println("Enter the no of rows:");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();

        System.out.println("Enter the no of cols:");
         int col = scan.nextInt();


        // If you want your boolean array to be false by default then use boolean not Boolean
        // because Boolean wrapper class has three value true, false and Null whereas boolean has only two
        boolean[][] board = new boolean[row][col];

         /*for( boolean[] ele : board) {
             for (boolean el : ele) {
                 System.out.print(el+ " ");
             }
             System.out.println();
         }*/
         // Starting with row=0 and col=0;
        int count = boards(board,0,0);

        System.out.println("Number of ways: "+count);
    }

}
