package cawang.algorithm.sort;

public class A {
	public int[] searchRange(int[] A, int target) {
		return searchRange_1(A,target);
	}
    public int[] searchRange_1(int[] A, int target) {
        if (A==null) return new int[]{-1,-1};;
        int low=0, high=A.length-1, mid=searchRange_1_helper(A,target,low,high,2);
		int boarderLow=searchRange_1_helper(A,target,low,mid,1);
		int boarderHigh=searchRange_1_helper(A,target,mid,high,0);
		System.out.println("mid: "+mid+"; boarderLow: "+boarderLow+"; boarderHigh"+boarderHigh );
		if( (boarderLow==-1&&boarderHigh==-1) || (boarderLow!=-1&&boarderHigh!=-1) ) 
			return new int[]{boarderLow,boarderHigh};;
		if(boarderLow==-1) boarderLow=boarderHigh;
		else boarderHigh=boarderLow;
		return new int[]{boarderLow,boarderHigh};
    }
    
     public int searchRange_1_helper(int[] A, int target,  int low, int high, int findLow) {
         int result=-1;
         while(low<=high){ 
			int mid=low+(high-low)/2;
			if (target==A[mid]){
			    int boarder;
			    if(findLow==2) return mid;
			    if(findLow==1) boarder=searchRange_1_helper(A, target, low, mid-1,1);
			    else boarder=searchRange_1_helper(A, target, mid+1,high,0);
			    result=boarder==-1?mid:boarder;
			    break;
			} 
			else if(target>A[mid]) low=mid+1;
			else high=mid-1;
		}
		return result;
     }
     
     public static void main(String[] args){
    	 A obj=new A();
    	 int[] a1=new int[]{1,1,2};
    	 int[] result1= obj.searchRange_1(a1, 1);
     }
}
