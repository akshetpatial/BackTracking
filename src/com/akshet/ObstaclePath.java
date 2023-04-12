package com.akshet;

import java.util.ArrayList;
import java.util.Scanner;

public class ObstaclePath {

    public static ArrayList<String> printPaths(int row, int col, int rowObs, int colObs) {
       return helperFunction(row,col,rowObs,colObs,"");
    }

    public static ArrayList<String> helperFunction(int row, int col, int rowObs, int colObs, String s) {
        ArrayList<String> path = new ArrayList<>();
        if(row ==1 && col==1){
            path.add(s);
            return path;
        }
        if(row==rowObs && col==colObs){
            return path;
        }
        ArrayList<String> Horizontal = new ArrayList<>();
        ArrayList<String> Vertical = new ArrayList<>();
        if(col>1) {
        Horizontal = helperFunction(row, col - 1, rowObs, colObs, s + "R");
        }
        if(row>1){
        Vertical = helperFunction(row-1, col, rowObs, colObs, s + "D");
        }
        path.addAll(Horizontal);
        path.addAll(Vertical);

        return path;
    }

    public static void main(String[] args) {
        System.out.println("Enter the row size");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();

        System.out.println("Enter the Col size");
        int col = scan.nextInt();

        System.out.println("Enter the Row Position where there is obstacle");
        int rowObs = scan.nextInt();

        System.out.println("Enter the Col Position where there is obstacle");
        int colObs = scan.nextInt();

        System.out.println("Print the Path that we follows:  ");
        ArrayList<String> path = printPaths(row,col,rowObs,colObs);
        System.out.println(path);
    }

}
