package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CityGraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	private city[] data;
	
	public CityGraph() throws FileNotFoundException {
		this.data = dataRead.Build_cities();
		this.E = 0;
		this.V = data.length;

		this.adj = (Bag<Integer>[]) new Bag[this.V];
		for(int i = 0; i < this.V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	
	public void add_all_edges() throws FileNotFoundException {

		File f = new File("data/connectedCities.txt");
		Scanner s = new Scanner(f);
		String line;
		String[] connect_info; 
		String first,second;
		int pos1,pos2;
		while(s.hasNextLine()) {

			line = s.nextLine();
			connect_info = line.split(", ");
			////////////////////////first connected city name
			first = connect_info[0];
			////////////////////////second connected city name
			second = connect_info[1];
			city[] temp = dataRead.Build_cities();

			////////////////////////find the index of city in data with the first name
			pos1 = BS_name(temp,0,temp.length-1,first.toUpperCase());
			pos2 = BS_name(temp,0,temp.length-1,second.toUpperCase());

			////////////////////////add edge on the two city in the graph
			if(pos1 != -1 && pos2 !=-1) {

				addEdge(temp[pos1].Get_No(),temp[pos2].Get_No());
			}
		}
		s.close();
		
	}
	
	
	public int V() {
		return this.V;
	}
	
	public int E() {
		return this.E;
	}

	
	public void addEdge(int v, int w) {
		this.adj[v].add(w);
		this.adj[w].add(v);
		this.E++;
	}
	
	public Iterable<Integer> adj(int v){
		return this.adj[v];
	}
	
///////////////////////////////////////////////////////////////////////////binary search	
	private int BS_name(city[] arr, int l, int r, String x) { 
		if (r >= l) { 
			int mid = l + (r - l) / 2; 
			if (arr[mid].Get_name().compareTo(x) == 0) 
				return mid;
			if (arr[mid].Get_name().compareTo(x) > 0) 
				return BS_name(arr, l, mid - 1, x); 
			return BS_name(arr, mid + 1, r, x); 
		} 
		
		return -1; 
	}
///////////////////////////////////////////////////////////////////////////search end

	public String toString() {
		StringBuilder s = new StringBuilder();
		city[] temp = this.data;
		code_to_name.resort(temp,temp.length);
		s.append(V + " vectices, " + E + " edges " + "\n");
		for(int v = 0; v < V; v++) {
			int pos1 = code_to_name.BS_code(temp,0,temp.length-1,v);
			s.append(temp[pos1].Get_name() + " :   ");
			for(int w : this.adj[v]) {
				int pos2 = code_to_name.BS_code(temp,0,temp.length-1,w);
				s.append(temp[pos2].Get_name() + "  ");}
			s.append("\n");
		}
		return s.toString();
		
	}
	

	
}

