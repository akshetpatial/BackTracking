package com.akshet;

import java.util.ArrayList;
import java.util.Scanner;

// Using BackTracking
public class AllPaths {

    public static ArrayList<String> printAllPaths(int row, int col) {

        Boolean[][] bool = new Boolean[row][col];
       return helperFunction(row,col,bool,"");
    }

    public static ArrayList<String> helperFunction(int row, int col, Boolean[][] bool, String s) {

        // If we Run the below code it will run infinite time as steps will get repeated
        ArrayList<String> check = new ArrayList<>();
        if(row==1 && col==1){
            check.add(s);
            return check;
        }

        ArrayList<String> path = new ArrayList<>();
        // For down
        if(row>1){
            path = helperFunction(row-1,col,bool,s+"D");
        }
        // For Right
        if(col>1){
            path = helperFunction(row,col-1,bool,s+"R");
        }
        // For Up
        if(row<3){
            path = helperFunction(row+1,col,bool,s+"U");
        }
        // For Left
        if(col<3){
            path = helperFunction(row,col+1,bool,s+"L");
        }
        check.addAll(path);
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
