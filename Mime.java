import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Mime {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        
        Hashtable<String,String> hash= new Hashtable<String,String>();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            hash.put(EXT.toLowerCase(),MT);
            in.nextLine();
        }
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            
            //get extension
            
            String[] array=FNAME.split("\\.(?=[^\\.]+$)");
            
            for (String retval: array){
                System.err.println( "ret:" + retval);
            } 
            
            String tipus="UNKNOWN";
            if (array.length>1){
                String extension=array[array.length-1];
    

                //get mime type
                String aux=hash.get(extension.toLowerCase());
                if (null!=aux){
                    tipus=aux;
                }
                System.err.println("file:" +FNAME + "/ext:" +extension.toLowerCase()+"/mime:"+ tipus );
            }else{
                //always unknown
                System.err.println("file:" +FNAME + "/mime:"+ tipus );
            }

            System.out.println(tipus);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("UNKNOWN"); // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
