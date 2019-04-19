package Graph;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
	public static void main(String[] args) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/a2_out.txt"));
		
		System.out.println("////////////////////////////////////////////////////////////////////" );
		System.out.println("Below are the cities read from text file:" );
		try{
			city[] data = dataRead.Build_cities();
			for(int i = 0; i < data.length; i++) {
				System.out.println(data[i].Get_name());
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		System.out.println("////////////////////////////////////////////////////////////////////" );
		System.out.println("Below is the CityGraph:" );
		CityGraph a = new CityGraph();
		a.add_all_edges();
		System.out.println(a.toString());
		System.out.println("////////////////////////////////////////////////////////////////////" );
		DFS A = new DFS(a,0);
		boolean r = A.hasPathTo(21);
		
		city[] x ;
		x = dataRead.Build_cities();
		code_to_name.resort(x,x.length);
		BFS B = new BFS(a,0);
		r = B.hasPathTo(21);
		writer.write("BFS : ");
		System.out.println("\nBoston has path to Minneapolis(BFS) : "+ r );
		Iterable <Integer> result = B.pathTo(21);
		for(Integer s : result) {
			int pos = code_to_name.BS_code(x,0,x.length-1,s);
			writer.write(x[pos].Get_name() + ",  ");
			System.out.print("->" + x[pos].Get_name());
		}
		
		
		System.out.println("\nBoston has path to Minneapolis(DFS) : "+ r );
		result = A.pathTo(21);
		writer.write("\nDFS : ");
		for(Integer s : result) {
			int pos = code_to_name.BS_code(x,0,x.length-1,s);
			writer.write(x[pos].Get_name() + ",  ");
			System.out.print("->" + x[pos].Get_name());
		}
		for(Integer s : result) {
			System.out.println(s);
		}
		
		System.out.println("\n////////////////////////////////////////////////////////////////////" );
		
		
		FoodADT[] food_list = dataRead.Build_menu();
		for(int i = 0; i < food_list.length; i++) {
			System.out.println(food_list[i].Get_price() + "  +  " + food_list[i].Get_res() + "  +  " + food_list[i].Get_name() );
		}
		System.out.println("////////////////////////////////////////////////////////////////////" );
		
		FoodADT[] wanted_list = Menu_arrays.Menu_list("M");
		System.out.println("Cheapest item in Mc is       " + wanted_list[0].Get_name() + "          " + wanted_list[0].Get_price() );
		System.out.println("Second cheapest item in Mc is       " + wanted_list[1].Get_name() + "          " + wanted_list[1].Get_price());
		System.out.println("////////////////////////////////////////////////////////////////////" );
		System.out.println("Below are the cities with its restaurants and two cheapest food:" );
		try{
			city[] data = dataRead.Build_cities();
			dataRead.add_restaurant(data);
			for(int i = 0; i < data.length; i++) {
				System.out.println(data[i].Get_name() + "    " + data[i].Get_res() +"    " + data[i].Get_menu()[0].Get_name() +"    " + data[i].Get_menu()[1].Get_name()  );
			}

		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		System.out.println("////////////////////////////////////////////////////////////////////" );
		x = dataRead.Build_cities();
		dataRead.add_restaurant(x);
		code_to_name.resort(x,x.length);

		ShortestPath S = new ShortestPath(a,0);
		System.out.println("Shortest Path with price : "+ r );
		writer.write("\nCity,Meal Choice,Cost of Meal\n");
		result = S.pathTo(21);
		for(Integer s : result) {
			int pos = code_to_name.BS_code(x,0,x.length-1,s);
			System.out.println("->" + x[pos].Get_name() + "   with food eaten:   " + S.Food(s).Get_name() );
			writer.write(x[pos].Get_name() + ", " + S.Food(s).Get_name() + ", $" + S.Food(s).Get_price()+"\n");
		}
		writer.close();
	}
	
}
