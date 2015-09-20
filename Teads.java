import java.util.*;
import java.io.*;
import java.math.*;

/**

 **/
class Teads {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer,Node> nodes= new TreeMap<Integer,Node>();
    
        
        int n = in.nextInt(); // the number of adjacency relations
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            System.err.println("read: " + xi +"/"+ yi);
            Node no=new Node(xi);
            Node mo= new Node(yi);
            if (nodes.containsKey(Integer.valueOf(xi))){
                no=nodes.get(Integer.valueOf(xi));
            }
            if (nodes.containsKey(Integer.valueOf(yi))){
                mo=nodes.get(Integer.valueOf(yi));
            }
            //link to adyacents
            no.link(mo);
            mo.link(no);
            nodes.put(Integer.valueOf(xi),no);
            nodes.put(Integer.valueOf(yi),mo);

        }

        
         int rounds=0;
         Collection colNodes= nodes.values();
		 int totalNodes=colNodes.size();
        
   
            List<Node> toRemove= new ArrayList<Node>();
         
            while(totalNodes>1){

                     for(Iterator<Node> it= colNodes.iterator() ; it.hasNext();) {
                                Node node = it.next();
                                if (1==node.contacts && node.visited==false ){
                                    toRemove.add(node);
                                    totalNodes--;
							        node.visited=true;
                                }
                     }
                    
                    for(Iterator<Node> at= toRemove.iterator(); at.hasNext();){
                            Node ax=at.next();

                            for(Node a: ax.link){
                                a.contacts--;
                            }
                            System.err.println("remove links   from node: " + ax.name);
                    }
                    toRemove.clear();
                    rounds++;
            } 
                    
        
        
        System.out.println(rounds); // The minimal amount of steps required to completely propagate the advertisement
    }
    

    
}

class Node{
    public int name;
	public boolean visited=false;
	public int contacts=0;

    public List<Node> link;
    
    public Node(int nom){
        this.name=nom;
        link=new ArrayList<Node>();

    }
    
    public void link(Node node){
        this.link.add(node);
		this.contacts++;
    }
	
    
    public boolean equals(Object obj){
        Node n=(Node)obj;
        if (this.name==n.name){
            return true;
        }else{
            return false;
        }
        
    }

}

