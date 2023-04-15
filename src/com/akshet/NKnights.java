package com.akshet;

import java.util.Scanner;

public class NKnights {

    public static int boards(boolean[][] board, int row , int col) {

        if(row==board.length) {
            display(board);
            return 1;
        }

        int count=0;

        for(int cl =0; cl<board[0].length; cl++) {
            if(isSafe(board,row ,cl)) {
                board[row][cl] = true;
                // This is for putting one element in one row only that is N elements with the broad of size n.
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
                    System.out.print(" K ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(boolean[][] board, int row , int col) {

 /*     This is one is also not required as we will be checking for the above element only
        // Right
        // Below Horizontal
        if(col+2<=board[0].length-1 && row+1<=board.length-1){
           if(board[row+1][col+2]){
               return false;
           }
        }

        // Below Vertical
        if(row+2<=board.length-1 && col+1<=board[0].length-1){
            if(board[row+2][col+1]){
                return false;
            }
        }
        // Left
        // Below Horizontal
        if(col-2>=0 && row+1<=board.length-1){
            if(board[row+1][col-2]){
                return false;
            }
        }

        // Below Vertical
        if(row+2<=board.length-1 && col-1>=0){
            if(board[row+2][col-1]){
                return false;
            }
        }*/

        // Right
        // Above Vertical
        if(row-2>=0 && col+1<=board[0].length-1){
            if(board[row-2][col+1]){
                return false;
            }
        }

        // Above Horizontal
        if(col+2<=board[0].length-1 && row-1>=0){
            if(board[row-1][col+2]){
                return false;
            }
        }

        // Left
        // Above Vertical
        if(row-2>=0 && col-1>=0){
            if(board[row-2][col-1]){
                return false;
            }
        }

        // Above Horizontal
        if(col-2>=0 && row-1>=0){
            if(board[row-1][col-2]){
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

        boolean[][] board = new boolean[row][col];

        // Starting with row=0 and col=0;
        int count = boards(board,0,0);

        System.out.println("Number of ways: "+count);
    }
}
