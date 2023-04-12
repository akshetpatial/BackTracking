package com.akshet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Using BackTracking
public class AllPaths {

    public static ArrayList<String> printAllPaths(int row, int col) {

        Boolean[][] bool = new Boolean[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                bool[i][j]=true;
            }
        }

        // Extra row and col just for the 2D bool array to iterate
       return helperFunction(row,col,bool,"",row,col);
    }

    public static ArrayList<String> helperFunction(int row, int col, Boolean[][] bool, String s, int rowB ,int colB) {

        // If we Run the below code it will run infinite time as steps will get repeated and this will stack overflow

        // Now let say we are marking the points whenever we are going

        // By doing this also we are getting incorrect result as it is now making the valid paths to invalid as well

        // Here By using Backtracking we can solve this in simple terms reverting back the change when the call comes out
        // of the recursion call
        ArrayList<String> check = new ArrayList<>();
        if(row==1 && col==1){
            check.add(s);
            return check;
        }

        if(!bool[rowB-row][colB-col])
            return check;

        bool[rowB-row][colB-col]=false;
        ArrayList<String> pathDown = new ArrayList<>();
        ArrayList<String> pathRight = new ArrayList<>();
        ArrayList<String> pathUp = new ArrayList<>();
        ArrayList<String> pathLeft = new ArrayList<>();
        // For down
        if(row>1){
           // bool[rowB-row][colB-col]=false;
            pathDown = helperFunction(row-1,col,bool,s+"D",rowB,colB);
        }
        // For Right
        if(col>1){
           // bool[rowB-row][colB-col]=false;
            pathRight = helperFunction(row,col-1,bool,s+"R",rowB,colB);
        }
        // For Up
        if(row<3){
            // bool[rowB-row][colB-col]=false;
            pathUp = helperFunction(row+1,col,bool,s+"U",rowB,colB);
        }
        // For Left
        if(col<3){
            // bool[rowB-row][colB-col]=false;
            pathLeft = helperFunction(row,col+1,bool,s+"L",rowB,colB);
        }

        // this is Backtracking
        // Now Here as we will be out of the recursive call at each level we will revert the changes
        bool[rowB-row][colB-col]=true;

        check.addAll(pathDown);
        check.addAll(pathRight);
        check.addAll(pathUp);
        check.addAll(pathLeft);
        return check;
    }

    public static void main(String[] args) {
        System.out.println("Enter the row size");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();

        System.out.println("Enter the Col size");
        int col = scan.nextInt();

        System.out.println("Print the Path that we follows:  ");
        ArrayList<String> path = printAllPaths(row,col);
        System.out.println(path);
    }

}
