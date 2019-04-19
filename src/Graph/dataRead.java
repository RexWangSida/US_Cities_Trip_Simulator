package Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dataRead{
	private static int N;
	public static city[] Build_cities()  throws FileNotFoundException{

		
		int lines = 0;
		File fi = new File("data/USCities.csv");
		Scanner c = new Scanner(fi);
		c.nextLine();
		while(c.hasNextLine()) {
			c.nextLine();
			lines++;
		}		
		c.close();
		N = lines;
		String[] city_info;
		city[] data = new city[N];
		File f = new File("data/USCities.csv");
		Scanner s = new Scanner(f);
		String line = s.nextLine();
		int index = 0;
		while(s.hasNextLine()) {
			line = s.nextLine();
			city_info = line.split(",");
			city new_city = new city(index,Integer.parseInt(city_info[0]),Integer.parseInt(city_info[1]),city_info[2],city_info[3], Double.parseDouble(city_info[4]),Double.parseDouble(city_info[5]));
			data[index] = new_city;
			index++;
		}
		s.close();
		sortMergeTD(data,N);

		return data;
	}
	
////////////////////////////////////////////////////////////////////////////sort cities
	private static city[] aux;
	private static boolean less(String v, String w) {
		return v.compareTo(w) < 0;
	}
	
	private static void merge(city[] a, int low, int mid, int high) {
		int i = low, j = mid+1;
		
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k =low; k <= high; k++) {
			if(i > mid)      a[k] = aux[j++];
			else if(j > high)  a[k] = aux[i++];
			else if(less(aux[j].Get_name(), aux[i].Get_name())) a[k] = aux[j++];
			else             a[k] =aux[i++];
		}
	}
	
	private static void sort(city[] a, int low, int high) {
	
		if(high <= low) return;
		int mid = low + (high - low)/2;
		sort(a,low,mid);
		sort(a, mid+1, high);
		merge(a, low, mid, high);
	
	}
	private static void sortMergeTD ( city [] x, int n ) {
		aux = new city [n];
		sort(x,0,n-1);
	}
///////////////////////////////////////////////////////////////////////////////sort cities end	
	
///////////////////////////////////////////////////////////////////////////////read food menu
	public static FoodADT[] Build_menu() throws FileNotFoundException {
		int lines = 0;
		File fi = new File("data/menu.csv");
		Scanner s = new Scanner(fi);
		s.nextLine();
		while(s.hasNextLine()) {
			s.nextLine();
			lines++;
		}		
		s.close();
		
		FoodADT[] result = new FoodADT[lines];
		
		File f = new File("data/menu.csv");
		Scanner c = new Scanner(f);
		c.nextLine();
		String[] food_info;
		String line;
		char restaurant;
		String price;
		double price_num;
		int index = 0;
		String name;
		while(c.hasNextLine()) {
			line =c.nextLine();
			food_info = line.split(",");
			restaurant = food_info[0].charAt(0);
			price = food_info[2].replace("$", "");
			price_num = Double.parseDouble(price);
			name = food_info[1];
			FoodADT food = new FoodADT(price_num,restaurant,name);
			result[index] = food;
			index ++;
		}
		c.close();
		
		return result;
	}
///////////////////////////////////////////////////////////////////////////////end of read food menu
	
	
///////////////////////////////////////////////////////////////////////////////read restaurant
	public static void add_restaurant(city[] c) throws FileNotFoundException {
		boolean W = false, M = false, B = false;
		for(int i = 0; i < c.length; i++) {
			double Long_min = c[i].Get_Long() - 0.5;
			double Long_max = c[i].Get_Long() + 0.5;
			double Lat_min = c[i].Get_Lat() - 0.5;
			double Lat_max = c[i].Get_Lat() + 0.5;
			File m = new File("data/mcdonalds.csv");
			Scanner s = new Scanner(m);
			s.nextLine();
			while(s.hasNextLine()) {
				String line =s.nextLine();
				String[] res_info = line.split(",");
				double longi = Double.parseDouble(res_info[0]);
				double lat = Double.parseDouble(res_info[1]);
				if( Long_min <=longi && longi <= Long_max) {
					if( Lat_min <=lat && lat <= Lat_max) {
						M = true;
						break;
					}
				}
					
			}
			s.close();
			File w = new File("data/wendys.csv");
			Scanner k = new Scanner(w);
			k.nextLine();
			while(k.hasNextLine()) {
				String line =k.nextLine();
				String[] res_info = line.split(",");
				double longi = Double.parseDouble(res_info[0]);
				double lat = Double.parseDouble(res_info[1]);
				if( Long_min <=longi && longi <= Long_max) {
					if( Lat_min <=lat && lat <= Lat_max) {
						W = true;
						break;
					}
				}
					
			}
			k.close();
			
			
			File b = new File("data/burgerking.csv");
			Scanner q = new Scanner(b);
			q.nextLine();
			while(q.hasNextLine()) {
				String line =q.nextLine();
				String[] res_info = line.split(",");
				double longi = Double.parseDouble(res_info[0]);
				double lat = Double.parseDouble(res_info[1]);
				if( Long_min <=longi && longi <= Long_max) {
					if( Lat_min <=lat && lat <= Lat_max) {
						B = true;
						break;
					}
				}	
			}
			q.close();
			
			
			if(W) {
				if(B) {
					if(M) {
						c[i].Set_res("WMB");
						c[i].Set_menu("WMB");
					}
					else {c[i].Set_res("BW");
						c[i].Set_menu("BW");
						}
					
				}
				else if (M) {
					c[i].Set_res("WM");
					c[i].Set_menu("WM");
				}
				
				else {c[i].Set_res("W");
					c[i].Set_menu("W");}
			}
	

			else if (M) {
				if(B) {c[i].Set_res("MB");
					c[i].Set_menu("MB");}
				else {c[i].Set_res("M");
					c[i].Set_menu("M");
				}
			}
			else if (B) {
				c[i].Set_res("B");
				c[i].Set_menu("B");
			}
		}	
	}
			

	

///////////////////////////////////////////////////////////////////////////////end of read restaurant
}
