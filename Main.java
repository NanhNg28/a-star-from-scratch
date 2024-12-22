import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
class PriorityComparator implements Comparator<node> {
    @Override
    public int compare(node o1, node o2) {
    	return Integer.compare(o1.f, o2.f);
    }
}
    
public class Main {
	int ex=0;
	public static node[] node ;
	
	public static void readfile() {
		int i = 0;
		
		try {
		File file=new File("D:\\EsclipseProject\\Astar\\input.txt");
		Scanner myScanner = new Scanner(file);
        int numOfLines = 0;
        while (myScanner.hasNextLine()) {
            numOfLines++;
            myScanner.nextLine();
        }
        myScanner.close();
        
        node = new node[numOfLines+1];
		
        myScanner = new Scanner(file);	
		while(myScanner.hasNext()) {
			String line=myScanner.nextLine();
			node[i] = new node(line.charAt(0));
            String[] words = line.split("\\s+");
            node[i].h = Integer.parseInt(words[words.length-1]);        
           for (int j = 1; j <= words.length-3; j +=2) {
	          	node[i].Child.put(words[j].charAt(0), Integer.parseInt(words[j+1]));
           }
			i++;
		}
		myScanner.close();
		}
		
		catch(FileNotFoundException e){
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void Astar(Character S, Character G) throws IOException {
		FileWriter file;
		
			file = new FileWriter("C:\\Users\\Admin\\OneDrive\\Desktop\\output.txt");
			BufferedWriter bw = new BufferedWriter(file);
		
		
		
		node v ;
		PriorityQueue<node> open = new PriorityQueue<>(new PriorityComparator());
		List<node> close = new ArrayList<node>();
		node O = null;
		node a = null;
		for(int i = 0;i<node.length-1;i++) {
			if(S==node[i].name) {
			O=node[i];
			break;
			}
		}
		open.add(O);
		
		while(true) {
			
			if(open.isEmpty()==true) {
				System.out.println("Tim kiem that bai");
				break;
			}
			a=open.poll();
			close.add(a);
			if(a.name==G) {
				System.out.println("tim kiem thanh cong");
				a.path(a);
				break;
			}
			List<Character>  keyList = new ArrayList<Character>();
			keyList.addAll(a.Child.keySet());
			
			System.out.print(a.name);v = new node();
			bw.write(a.name);
			for(int i = 0; i  < a.Child.size();i++) {
				
				Character key = keyList.get(i);
				for(int j = 0;j<node.length-1;j++) {
					if(key==node[j].name) {
						v=node[j];
						break;		
					}
				}
						v.par = a;
						v.k = a.Child.get(v.name);
						v.g=v.k+a.g;
						v.f=v.g+v.h;
	
				if(!open.contains(v))
					{
						open.add(v);
					}
				
				System.out.println("   "+v.name+" "+v.k+" "+v.h+" "+v.g+" "+v.f);
				bw.write("   "+v.name+" "+v.k+" "+v.h+" "+v.g+" "+v.f+"\n");
				
       }
			bw.write(open.toString()+"\n" );
			System.out.print(open);			
			System.out.println(" ");	
		}
		bw.close();
	}


	public static void main(String[] args) {
		readfile();
		try {
			Astar('A','B');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
