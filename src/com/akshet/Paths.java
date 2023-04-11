package com.akshet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Paths {

    // Here if we see the recursion tree then there are multiple duplicates which we can neglect to evaluate again.
    // My doing memorization as if we give a large number to rows and columns the code will break
    public static int CountPaths(int row, int col) {
        int count=0;
        if(row == 1 || col ==1 )
            return 1;
        int value =  CountPaths(row-1,col) + CountPaths(row,col-1);
        count+=value;
        return count;
    }

    public static Integer CountPaths_Opt(int row, int col) {
        Map<String,Integer> check = new HashMap<>();
        return helperFunction(row,col,check);
    }

    // This is using memorization as we are keeping the track of the repeated keys and we will return it instead of solving it
    // again
    public static Integer helperFunction(int row, int col, Map<String, Integer> check) {
        String key = row+" "+col;
        int count=0;
        for(String keys : check.keySet()){
            if(keys.equals(key))
                return check.get(key);
        }
        if(row == 1 || col ==1 )
            return 1;

        int value =  helperFunction(row-1,col,check) + helperFunction(row,col-1,check);
        check.put(key,value);
        count+=value;
        return count;
    }

    public static ArrayList<String> printPaths(int row, int col) {
        return helperFunctionPath(row,col,"");
        }

    public static ArrayList<String> helperFunctionPath(int row, int col, String s) {
        ArrayList<String> path = new ArrayList<>();

        int tempRow=row;
        int tempCol=col;
        if(row == 1 ){
            StringBuilder sBuilder = new StringBuilder(s);
            while(tempCol!=1){
                sBuilder.append("R");
                tempCol--;
            }
            s = sBuilder.toString();
            path.add(s);
            return path;
        }
        if(col == 1 ){
            StringBuilder sBuilder = new StringBuilder(s);
            while(tempRow!=1){
                sBuilder.append("D");
                tempRow--;
            }
            s = sBuilder.toString();
            path.add(s);
            return path;
        }

        ArrayList<String> straight=  helperFunctionPath(row-1,col,s+"D");
        ArrayList<String> down=helperFunctionPath(row,col-1,s+"R");
        path.addAll(straight);
        path.addAll(down);
        return path;
    }

    public static void main(String[] args) {
        System.out.println("Enter the row size");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();

        System.out.println("Enter the Col size");
        int col = scan.nextInt();

        System.out.println("No of Ways we can go to the last point while moving up or down only not diagonally: ");
        int count = CountPaths(row,col);
        System.out.println(count);

        System.out.println("Optimised approach: ");
        int count_1 = CountPaths_Opt(row,col);
        System.out.println(count_1);

        System.out.println("Print the Path that we follows: ");
        ArrayList<String> path = printPaths(row,col);
        System.out.println(path);
    }

}
