import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Horse {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int[] strenghs= new int[N];
        
        for (int i = 0; i < N; i++) {
            int Pi = in.nextInt();
            strenghs[i]=Pi;
        }
        
        int str=99999999;
        //look for the nearest stregnts
        /*
        for(int i=0; i<N; i++){
            int stri= strenghs[i];
            for (int j=i+1; j<N; j++){
                 int strj= strenghs[j];
                 if (Math.abs(strj-stri)<str){
                     str=Math.abs(strj-stri);
                 }
            }
            
        }
        */
        
        //the difference between adjacents numbers MUST be less than the difference between no adjacents elements i a sorted array
        Arrays.sort(strenghs);
            if (strenghs.length > 1) {
                int d = Math.abs(strenghs[0] - strenghs[1]);
                for (int i = 0; i <= strenghs.length; i++) {
                    if (i + 1 < strenghs.length) {
                        int t = Math.abs(strenghs[i] - strenghs[i + 1]);
                        if (t < d) {
                            d = t;
                        }
                    }
                }
            str=d;
        }
        

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(str);
    }
}
