import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class node   {
	
	Character name ;
	node par = null;
	int g=0;
	int h=0;
	int f=0;
	int k =0;
	public Map<Character, Integer> Child = new HashMap();
	public int f() {
		return g+h;
	}
	@Override
	public String toString() {
		return name+""+f;
	}
	node(){
		this.g=0;
		this.h=0;
		this.f=0;
		this.k=0;
	}
	node(Character name,int g,int h) {
		this.name=name;
		this.g=g;
		this.h=h;	
	}
	node(Character name) {
		this.name=name;	
	}
	node(Character name,int h) {
		this.name=name;
		this.h=h;
	}
	
	public Boolean equal(node E) {
		if(this.name==E.name)
			return true;
		return false;
	}
	
	public void path(node O) {
		System.out.print(O.name+" ");
		if(O.par != null) 
			path(O.par);
		else
			return;
	}
}
