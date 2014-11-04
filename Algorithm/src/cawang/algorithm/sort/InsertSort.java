package cawang.algorithm.sort;

/**
 * @author cawang
 * O(n^2)
 * faster if the array is highly sorted
 */
public class InsertSort extends AbstractSort implements ISort {


	@Override
	public Comparable[] sort(Comparable[] array) {
		printArray(true, array);
		if(array==null)return null;
		for(int i=1;i<array.length;i++){
			for(int j=i;j>0&&array[j].compareTo(array[j-1])<0;j--){ //notice the stopping condition
				Comparable temp=array[j-1];
				array[j-1]=array[j];
				array[j]=temp;
			}
		}
		printArray(false, array);
		return array;
	}
	/**
	 * @author cawang
	 * also O(n^2), because need to move element
	 * 
	 */
	public Comparable[] sort_binary (Comparable[] array) {
		
		printArray(true, array);
		if(array==null)return null;
		for(int i=1;i<array.length;i++){
			int targetIdx;
			int min=0;
			int max=i-1;
			int mid=min+(max-min)/2;
			//find where to insert array[i] in array[0]->array[i-1], using binary serach
			while(min<=max){
				mid=min+(max-min)/2;
				if(array[i].compareTo(array[mid])==0) break;
				else if (array[i].compareTo(array[mid])>0)min=mid+1;
				else max=mid-1;
			}
			targetIdx=(array[i].compareTo(array[mid])<0)?mid:mid+1; //if <, mid, not mid-1
			//System.out.println("targetIdx: "+targetIdx);
			Comparable temp=array[i];
			for(int j=i;j>targetIdx;j--){
				array[j]=array[j-1];
			}
			array[targetIdx]=temp;
		}
		printArray(false, array);
		return array;
	}
	
	public Comparable[] _sort_link (Comparable[] array) {
		
		return null;
	}
	
	//not understand
	public Comparable[] _sort_shell (Comparable[] array) {
		printArray(true, array);
		int h=1;
		while(h<array.length/3)h=3*h+1; //Notice! h begins from the biggest number, than reduce by /3
		while(h>1){
			for(int j=h;j<array.length;j++){ //Notice!
				for(int i=j;i>=h&&array[i].compareTo(array[i-h])<0;i-=h){//Notice!
					Comparable temp=array[i];
					array[i]=array[i-h];
					array[i-h]=temp;
				}
			}
			h=h/3; //Notice!
		}
		
		printArray(false, array);
		return array;
	}
	

}
