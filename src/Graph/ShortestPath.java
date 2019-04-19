package Graph;

import java.io.FileNotFoundException;

public class ShortestPath {
	private int size;
	private Integer[] path;
	private boolean [] marked;
	private final int source;
	private double[] distTo;
	private FoodADT[] food;
	public ShortestPath(CityGraph G, int s) throws FileNotFoundException {
		this.source = s;
		this.size = G.V();
		this.path = new Integer[this.size];
		boolean[] marked = new boolean[this.size];
		this.food = new FoodADT[this.size];
		this.marked = marked;
		this.distTo = new double [this.size] ; 
		for(int v = 0; v < this.size; v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
			marked[v] = false;
		}
		food[0] = new FoodADT(0,'-',"None");
		DijkstraSP(G,this.source);
	}
	
	private void DijkstraSP(CityGraph G, int s) throws FileNotFoundException {
		city[] cities = dataRead.Build_cities();
		code_to_name.resort(cities,cities.length);
		dataRead.add_restaurant(cities);
		Stack<Integer> stack = new Stack<Integer> ();
		stack.push(s);
		////confirm start from source
		this.distTo[s] = 0;
		while(stack.size() != 0){
			int v = stack.pop();
			marked[v] = true;
			for(int vertex : G.adj(v)) {
				if(!marked[vertex]) {

					if((cities[vertex].Get_menu()[0]).Get_name().equals(food[v].Get_name())) {
						if(distTo[v] + cities[vertex].Get_menu()[1].Get_price() < distTo[vertex]) {
							path[vertex] = v;
							distTo[vertex] = distTo[v] + cities[vertex].Get_menu()[1].Get_price();
							food[vertex] = cities[vertex].Get_menu()[1];
						}
					}
					else {
						if(distTo[vertex] > distTo[v] + cities[vertex].Get_menu()[0].Get_price())
						{
							path[vertex] = v;
							distTo[vertex] = distTo[v] + cities[vertex].Get_menu()[0].Get_price();
							food[vertex] = cities[vertex].Get_menu()[0];
						}
					}

				}
			}
			double lowest = Double.POSITIVE_INFINITY;
			int lowest_index = 0;
			boolean lowest_found = false;
			for(int i = 0; i < this.size; i++) {
				if(distTo[i] < lowest && marked[i] == false) {
					lowest = distTo[i];
					lowest_index = i;
					lowest_found = true;
				}
			}
			if(lowest_found)
				stack.push(lowest_index);
		}
		
	}
	
	   public FoodADT Food(int v){
		   return this.food[v];
	   }
	   
	   public boolean hasPathTo(int v) {
		   return marked[v];
	   }
	   public Iterable <Integer> pathTo(int v){
		   if(!hasPathTo(v)) return null;
		   Stack<Integer> path = new Stack<Integer>();
		   for(int x = v; x !=this.source; x = this.path[x])
			   path.push(x);
		   path.push(this.source);
		   return path;
	   }
	   

	

}
