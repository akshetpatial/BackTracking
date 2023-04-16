package com.akshet;

public class Sudoku {

    public static void solveSudoku(char[][] board) {

//        helperFunction(board, 0,0);
        if(helperFunction(board)){
            display(board);
        }
    }

//    public static void helperFunction(char[][] board, int row, int col) {
      public static boolean helperFunction(char[][] board) {


        int n = board.length;
        int row =-1;
        int col=-1;

        boolean emptyLeft = true;

        for( int i =0; i<n;i++){
            for(int j=0;j<n;j++){
                if(isEmpty(board,i,j)){
                    row =i;
                    col=j;
                    emptyLeft = false;
                    break;
                }
            }
            // In the current Row
            if(!emptyLeft){
                break;
            }

        }
        // This means Sudoku is solve
        if(emptyLeft)
            return true;

        // BackTrack
          for( int num=1; num<10;num++){
              char ch= (char) (num+'0');
              if(isValid(board,row,col,ch)){
                  board[row][col]=ch;
                  // This is the line which goes back to the method call
                  if(helperFunction(board))
                      return true;
                  else
                      board[row][col]='.';
              }
          }
            return false;
       /* if(row==board.length){
            display(board);
            return;
        }

        for(int cl =0;cl<board[0].length;cl++){
            if(isEmpty(board, row,cl)){
                for( int num =1;num<10;num++){
                    char n = (char) (num+'0');
                    if(isValid(board,row,cl,n)){
                        board[row][cl]=n;
                        break;
                    }
                    if(board[row][cl]=='.'){
                       board[row][cl-1]='.';
                    }
                }

            }
        }
        helperFunction(board,row+1,0);*/


       /* if(row==board.length){
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isEmpty(board, row, i)) {
                while (num <= 9) {
                    char n = (char) (num+'0');
                    if (isValid(board, row, i, n)) {
                        board[row][i] = n;
                        break;
                    }
                    num++;
                }
                if(num==10){
                    char ch = board[row-1][i];
                    int val = Integer.parseInt(String.valueOf(ch));
                    board[row-1][i]='.';
                    helperFunction(board, row - 1, val+1);
                  *//*  row=row-1;
                    char ch = board[row][i];
                    int val = Integer.parseInt(String.valueOf(ch));
                    for( int n=val+1;n<=9;n++){
                        char t = (char) (n+'0');
                        if (isValid(board, row, i, t)) {
                            board[row][i] = t;
                            break;
                        }
                    }*//*
                }
            }
            num=1;

            helperFunction(board, row + 1, num);
        }*/


    }

    private static void display(char[][] board) {
        for(char[] row: board){
            for(char ch: row){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    public static boolean isEmpty(char[][] board, int row, int col) {
        return board[row][col] == '.';
    }

    public static boolean isValid(char[][] board, int row, int col, char num) {

        /*
            Just check for the Entire Row and Col
        // right
        for (int i = col; i < board[0].length; i++) {
            if (board[row][i] == num)
                return false;
        }

        // left
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == num)
                return false;
        }

        // up
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == num)
                return false;
        }

        // down
        for (int i = row; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }*/

        // Checking Entire Column
        for (int cl = 0; cl < board[0].length; cl++)
            if (board[row][cl] == num)
                return false;

        // Checking Entire Row
        for (int rw = 0; rw < board.length; rw++)
            if (board[rw][col] == num)
                return false;

        // Checking the 3 x 3 matrix
        int startRow= row - row%3;
        int startCol= col - col%3;

        for( int rw =startRow;rw<startRow+3;rw++){
            for(int cl=startCol;cl<startCol+3;cl++){
                if(board[rw][cl]==num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Sudoku! ");

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        display(board);
        System.out.println();

        solveSudoku(board);
    }
}
