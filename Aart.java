import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Aart {

    
    public static void main(String args[]) {
        
        int NUM_LETTERS=27;
        char[] alfabet= {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','?'
        };
    
    
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        //to store the letter in asci artM
        char[][] art=new char[H][L*NUM_LETTERS];
        String T = in.nextLine(); //text to translate
        
        System.err.println("create array L:" + L + "/H:"+ H+"/to translate:" + T );
        
        
        
        //saving asci art
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine(); //first line of all letters in asci art
            //the ROW must be saved in L chars groups
           // System.err.println("readed->" + ROW);
            char[] aux=ROW.toCharArray();
            for(int j=0; j<aux.length; j++){
               // System.err.println("guardando->["+i+"]["+j+"]" + aux[j]);
                art[i][j]=aux[j];
            }
            
             
        }
        
        StringBuilder builder= new StringBuilder(); 
        char[] translation=T.toCharArray();
            for(int m=0; m<H; m++){
                StringBuilder linea= new StringBuilder();
                for(int j=0; j<translation.length; j++){
                     //neet to get char -> letter number to get position
                    int position= returnPosition(Character.toUpperCase(translation[j]),alfabet);
                    
                    int start=(position*L);
                    for(int u=start; u<(start+L); u++){
                        linea.append(art[m][u]);
                    }
                    
                }
                System.out.println(linea);
            }
            

        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
    
    
    static int returnPosition(char letter, char[] letters){
        int i=26;
        for(int j=0; j<letters.length; j++){
            if (letter == letters[j]){
                i=j;
            }
            
        }
        //System.err.println("letter:" +letter + "/pos letter->" + i);
        return i;
    }
}
