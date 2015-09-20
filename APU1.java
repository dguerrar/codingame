import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class APU1 {

    public static void main(String args[]) {
        
        List<Node> nodes= new ArrayList<Node>();
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        
        Node[] verts=new Node[width];
        Node lastNodeVer=null;
        for (int j = 0; j < height; j++) {
            
            String line = in.nextLine(); // width characters, each either 0 or .
            System.err.println("readline:" + line);
            //parse line into chars
            Node lastNodeHor=null;
            for(int i=width; i>0; i--){
                //in reverse
                Node no= new Node(i-1,j,line.substring(i-1,i));
     
                if (no.valor.equalsIgnoreCase("0")){
                    //initizlize next node right
                    no.right=lastNodeHor;
                    lastNodeHor=no;
                    //assig  node bottom
                    if (null!=verts[i-1]){
                        verts[i-1].bottom=no;
                    }
                    verts[i-1]=no;
                    
                    nodes.add(no);
                    no.print();
                }
                
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        //start to compute
        for (int j = 0; j < height; j++) {
            for(int i=0; i<width; i++){
                //test nodes to the right
                Node test= new Node(i,j);
                if (nodes.contains(test)){
                    int index=nodes.indexOf(test);
                    if (-1!=index){
                        Node local= nodes.get(nodes.indexOf(test));
                        StringBuilder builder= new StringBuilder();
                       

                            builder.append(local.x +" "+ local.y);
                            //right
                            builder.append(testNode(i, j,nodes,1));
                            
                            //botton
                            builder.append(testNode(i, j, nodes,2));
                            System.out.println(builder.toString());
                        }
                    
                }
                
            }
        }



        //System.out.println("0 0 1 0 0 1"); // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
    
    
    public static String testNode(int x, int y, List<Node> nodes,int pos){
            //upper right
            StringBuilder builder= new StringBuilder();
            Node aux= new Node(x,y);
            aux= nodes.get(nodes.indexOf(aux));
            if (pos==1){
                if (null!=aux.right){
                    builder.append(" " + aux.right.x+" "+aux.right.y);      
                }else{
                    builder.append(" -1 -1");
                }
            }else{
                if (null!=aux.bottom){
                    builder.append(" " + aux.bottom.x+" "+aux.bottom.y);      
                }else{
                    builder.append(" -1 -1");
                } 
                
            }
            
            return builder.toString();
        
        
    }
    
    
}


class Node{
    
    Node right;
    Node bottom;
    int x;
    int y;
    String valor;



    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Node(int x, int y,String value){
        this.x=x;
        this.y=y;
        this.valor= value;
    }
    
    
    public boolean equals(Object obj){
        Node newObj= (Node)obj;
        
        return (this.x==newObj.x && this.y==newObj.y);
    }
    
    public void print(){
        
        System.err.println("node at x:" + x +"/y:"+ y+"/valor:"+valor);
    }
    
    public String toString(){
        
        return "node at x:" + x +"/y:"+ y+"/valor:"+valor;
    }
    
}
