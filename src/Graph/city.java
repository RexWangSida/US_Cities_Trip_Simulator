package Graph;

import java.io.FileNotFoundException;

public class city{
	
	private int state,code;
	private String ABBREVIATION,name;
	private double Lat, Long;
	private FoodADT[] menu;
	private String res;
	private int No;
	public city(int No,int state, int code, String ABBREVIATION, String name, double Lat, double Long){
		this.No = No;
		this.state = state;
		this.code = code;
		this.ABBREVIATION = ABBREVIATION;
		this.name = name;
		this.Lat = Lat;
		this.Long = Long;
	}
	
	public int Get_No() {
		return this.No;
	}
	
	public int Get_state() {
		return this.state;
	}
	
	public int Get_code() {
		return this.code;
	}
	
	public String Get_ABBREVIATION() {
		return this.ABBREVIATION;
	}
	
	public String Get_name() {
		return this.name;
	}
	
	public double Get_Lat() {
		return this.Lat;
	}
	
	public double Get_Long() {
		return this.Long;
	}

	public void Set_menu(String S) throws FileNotFoundException {
		this.menu = Menu_arrays.Menu_list(S);
	}	
	
	public FoodADT[] Get_menu()  {
		return this.menu;
	}
	
	public void Set_res(String S) throws FileNotFoundException {
		this.res = S;
	}	
	
	public String Get_res()  {
		return this.res;
	}
	
	
}
