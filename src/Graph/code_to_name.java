package Graph;

public class code_to_name {
////////////////////////////////////////////////////////////////////////////search start
	public static int BS_code(city[] arr, int l, int r, int x) { 
		if (r >= l) { 
			int mid = l + (r - l) / 2; 
			if (arr[mid].Get_No() == x) 
				return mid;
			if (arr[mid].Get_No() > x) 
				return BS_code(arr, l, mid - 1, x); 
			return BS_code(arr, mid + 1, r, x); 
		} 
		
		return -1; 
	}
////////////////////////////////////////////////////////////////////////////search end
////////////////////////////////////////////////////////////////////////////resort start
	private static city[] aux;

	
	private static void merge(city[] a, int low, int mid, int high) {
		int i = low, j = mid+1;
		
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k =low; k <= high; k++) {
			if(i > mid)      a[k] = aux[j++];
			else if(j > high)  a[k] = aux[i++];
			else if(aux[j].Get_No()< aux[i].Get_No() )a[k] = aux[j++];
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
	public static void resort( city [] x, int n ) {
		aux = new city [n];
		sort(x,0,n-1);
	}
////////////////////////////////////////////////////////////////////////////resort end
}
