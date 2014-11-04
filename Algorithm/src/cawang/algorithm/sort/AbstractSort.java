/**
 * 
 */
package cawang.algorithm.sort;

/**
 * @author cawang
 *
 */
public abstract class AbstractSort implements ISort{
	protected void printArray(boolean isOriginal, Comparable[] array){
		String prefix=this.getClass().getSimpleName()+"/"+getCallerName(3);
		if(isOriginal){
		System.out.println(SortUtil.printArray(prefix+"/Original Array: ", array));
		}
		else
			System.out.println(SortUtil.printArray(prefix+"/New Array: ", array));
	}
	
	private  void  getCaller(){   
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();  
        for (StackTraceElement ste:stack){   
         if((ste.getClassName().indexOf("T1"))!=-1){
             System.out.println("called by "+ste.getClassName()+"."+ste.getMethodName()+"/"+ste.getFileName());
         }
        }   
      }  
	
	/**
	 * @param index
	 * @return
	 * 0: getStackTrace()
	 * 1: getCallerName()
	 * 2: should be printArray()
	 * 3: sort()
	 */
	private  String  getCallerName(int index){   
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();  
        return stack[index].getMethodName();
        
      }
	protected void exchange(Comparable[] array, int i, int j) {
		SortUtil.exchange(array, i, j);
	}
	@Override
	public abstract Comparable[] sort(Comparable[] array);  
}
