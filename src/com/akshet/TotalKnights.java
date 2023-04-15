package com.akshet;

import java.util.Scanner;

public class TotalKnights {

    private static int boards(boolean[][] board, int row, int col) {

        // This we can use if only the count is asked not the board itself otherwise follow the below code
       /* if(board.length==board[0].length)
            return (board.length)*(board[0].length)/2;*/

        int count =0;

        if(row==board.length){
            count =  displayAndCount(board);
            System.out.println();
            return count;
        }

        for(int i=0;i<board[0].length;i++){
            if(row<board.length && isSafe(board,row,i)) {
                board[row][i]=true;
             count+=  boards(board, row + 1, i);
                board[row][i]=false;
            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
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

    public static int displayAndCount(boolean[][] board) {
        int count=0;
        for(boolean[] tRow : board){
            for(boolean tcCol : tRow){
                if(tcCol) {
                    count++;
                    System.out.print(" K ");
                }
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
        return count;
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

        System.out.println("Number of Knights in all possible cases: "+count);
    }

}
