package Graph;

import java.io.FileNotFoundException;

public class Menu_arrays {

	
	public static FoodADT[] Menu_list(String res) throws FileNotFoundException {
		FoodADT[] total;
		total = dataRead.Build_menu();
		int W = 0, M = 0, B = 0;
		//get number of food of each restaurant
		for(int i = 0; i < total.length; i++) {
			if(total[i].Get_res() == 'W') {
				W += 1;
			}
			else if(total[i].Get_res() == 'M')
				M += 1;
			else if(total[i].Get_res() == 'B')
				B += 1;
		}


		FoodADT[] W_list = new FoodADT[W];
		FoodADT[] M_list = new FoodADT[M];
		FoodADT[] B_list = new FoodADT[B];
		FoodADT[] WM_list = new FoodADT[W+M];
		FoodADT[] MB_list = new FoodADT[M+B];
		FoodADT[] BW_list = new FoodADT[B+W];
		int W_in = 0;
		int M_in = 0;
		int B_in = 0;
		int WM_in = 0;
		int MB_in = 0;
		int BW_in = 0;
		//build lists
		for(int i = 0; i < total.length; i++) {
			if(total[i].Get_res() == 'W') {
				W_list[W_in] = total[i];
				W_in++;
				WM_list[WM_in] = total[i];
				WM_in++;
				BW_list[BW_in] = total[i];
				BW_in++;
			}
			else if(total[i].Get_res() == 'M') {
				M_list[M_in] = total[i];
				M_in++;
				WM_list[WM_in] = total[i];
				WM_in++;
				MB_list[MB_in] = total[i];
				MB_in++;
			}

			else if(total[i].Get_res() == 'B') {
				B_list[B_in] = total[i];
				B_in++;
				BW_list[BW_in] = total[i];
				BW_in++;
				MB_list[MB_in] = total[i];
				MB_in++;
			}
		}


		sort_menu(total,total.length);
		sort_menu(W_list,W_list.length);
		sort_menu(M_list,M_list.length);
		sort_menu(B_list,B_list.length);
		sort_menu(WM_list,WM_list.length);
		sort_menu(MB_list,MB_list.length);
		sort_menu(BW_list,BW_list.length);
		
		if(res.equals("W")) {
			FoodADT[] return1 = new FoodADT[2];
			return1[0] = W_list[0];
			return1[1] = W_list[1];
			return return1;
		}
		else if(res.equals("M")) {
			FoodADT[] return2 = new FoodADT[2];
			return2[0] = M_list[0];
			return2[1] = M_list[1];
			return return2;
		}
		else if(res.equals("B")) {
			FoodADT[] return3 = new FoodADT[2];
			return3[0] = B_list[0];
			return3[1] = B_list[1];
			return return3;
		}
		
		else if(res.equals("WM")) {
			FoodADT[] return4 = new FoodADT[2];
			return4[0] = WM_list[0];
			return4[1] = WM_list[1];
			return return4;
		}
		else if(res.equals("MB")) {
			FoodADT[] return5 = new FoodADT[2];
			return5[0] = MB_list[0];
			return5[1] = MB_list[1];
			return return5;
		}
		else if(res.equals("BW")) {
			FoodADT[] return6 = new FoodADT[2];
			return6[0] = BW_list[0];
			return6[1] = BW_list[1];
			return return6;
		}
		else if(res.equals("WMB")) {
			FoodADT[] return7 = new FoodADT[2];
			return7[0] = total[0];
			return7[1] = total[1];
			return return7;
		}

		return null;
	}
////////////////////////////////////////////////////////////sort menu
	private static FoodADT[] aux;
	
	private static void merge(FoodADT[] a, int low, int mid, int high) {
		int i = low, j = mid+1;
		
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k =low; k <= high; k++) {
			if(i > mid)      a[k] = aux[j++];
			else if(j > high)  a[k] = aux[i++];
			else if(Double.compare(aux[j].Get_price(), aux[i].Get_price()) < 0) a[k] = aux[j++];
			else             a[k] =aux[i++];
		}
	}
	
	private static void sort(FoodADT[] a, int low, int high) {
	
		if(high <= low) return;
		int mid = low + (high - low)/2;
		sort(a,low,mid);
		sort(a, mid+1, high);
		merge(a, low, mid, high);
	
	}
	private static void sort_menu( FoodADT [] x, int n ) {
		aux = new FoodADT [n];
		sort(x,0,n-1);
	}
////////////////////////////////////////////////////////////sort end
}
