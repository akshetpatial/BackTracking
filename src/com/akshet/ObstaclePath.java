package com.akshet;

import java.util.ArrayList;
import java.util.Scanner;

public class ObstaclePath {

    public static ArrayList<String> printPaths(int row, int col, int rowObs, int colObs) {
       return helperFunction(row,col,rowObs,colObs,"");
    }

    public static ArrayList<String> helperFunction(int row, int col, int rowObs, int colObs, String s) {
        ArrayList<String> path = new ArrayList<>();

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
