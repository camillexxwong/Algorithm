/**
 * 
 */
package cawang.algorithm.sort;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cawang
 * Test Class for implementation Classes of ISort
 * How to Use?
 * -Create new sort class that implementates ISort
 * -init new object of sort class in SortTest field
 * -add testcases in Cases accordingly
 * -name the to-be-test method in sort class begin with "sort"
 */
public class SortTest{
	private ArrayList<TestCase> testCases=new ArrayList<TestCase>();
	private ISort bubble=new BubbleSort();
	private ISort selection=new SelectionSort();
	private ISort insert=new InsertSort();
	private ISort merge=new MergeSort();
	private ISort quick=new QuickSort();
	private ISort heap=new HeapSort();
	public SortTest(){
		super();
	}
	
	
	/**
	 * @author cawang
	 * Inner Class, SortTest.TestCase, Test Case Class for SortTest
	 */
	public class TestCase implements ITestCase {
		Comparable[] array;
		Comparable[] result;
		
		public TestCase(){
			super();
		}
		public TestCase(Comparable[] array, Comparable[] result){
			this.array=array;
			this.result=result;
		}
		@Override
		public Object getResult() {
			return this.result;
		}

		@Override
		public Object[] getParams() {
			Object[] params=new Object[]{this.array};
			return params;
		}
		
		@Override
		public String toString() {
			return "TestCase: "+Arrays.toString(array)+"Expected Result: "+Arrays.toString(result);
		}
	}
	
	/**
	 * @author cawang
	 * Inner Class, constants array sources and results;
	 */
	public class Cases{
		Comparable[] source1=new Integer[]{3,2,1,2,4,5,-1,0,3,3};
		Comparable[] result1=new Integer[]{-1,0,1,2,2,3,3,3,4,5};
		Comparable[] source2=new Integer[]{0};
		Comparable[] result2=new Integer[]{0};
		Comparable[] source3=new Integer[]{};
		Comparable[] result3=new Integer[]{};
		Comparable[] source4=null;
		Comparable[] result4=null;
		Comparable[] source5=new String[]{"abc","ab","abd","b"};
		Comparable[] result5=new String[]{"ab","abc","abd","b"};
		Comparable[] source6=new Integer[]{3,2,1,2,4,5,-1,0,3,3,7,7,6,10,9,15,14,18};
		Comparable[] result6=new Integer[]{-1,0,1,2,2,3,3,3,4,5,6,7,7,9,10,14,15,18};
	}
	@Before
	public void generateTestCases() throws IllegalArgumentException, IllegalAccessException{
		Cases objCases=new Cases();
		Field[] fields=Cases.class.getDeclaredFields();
		ArrayList<Comparable[]> sources=new ArrayList<Comparable[]>();
		ArrayList<Comparable[]> results=new ArrayList<Comparable[]>();
		for(Field f:fields){
			if(f.getName().contains("source"))sources.add((Comparable[])f.get(objCases));
			else if(f.getName().contains("result"))results.add((Comparable[])f.get(objCases));
		}
		
		for(int i=0;i<sources.size();i++){
			testCases.add(new TestCase(sources.get(i),results.get(i)));
		}
	}
	
	/**
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * 
	 * test all ISort objects declared in SortTest Class field, as sortObjs
	 * test all method that start with "sort" of sortObj
	 * test all testcases of testCases
	 */
	@Test
	public void testAllSort() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		SortTest obj=new SortTest();
		Field[] fields=SortTest.class.getDeclaredFields();
		for(Field f:fields){
			if(f.get(obj) instanceof ISort){
				//get all objs which is instance of ISort
				ISort sortObj=(ISort) f.get(obj);
				//get all to-be-tested methods of each sortObj
				Method[] methods=sortObj.getClass().getDeclaredMethods();
				for(Method m:methods){
					if(!m.getName().startsWith("sort")) continue;
					//test each testcase for each method of each sortObj
					generateTestCases(); //after continue; generate must match clear!
					int caseIndex=0;
					for(TestCase t:testCases){
						String msg="Class: "+sortObj.getClass().getName()+"; Method: "+m.getName()+
								"; TestCase"+(++caseIndex)+": "+t.toString();
						//Deal with null
						Object n=null; //cannot use null as invoke parameter directly
						if(t.getParams()[0]==null)assertTrue("null case", m.invoke(sortObj, n)==null);
						//Deal with arrays, compare each element, or use toString and compare the String
						else if(t.getResult() instanceof Comparable[]){ //Cannot use ==Comparable[].class, return Integer[] actually
							assertEquals(msg,Arrays.toString((Comparable[])t.getResult()),Arrays.toString((Comparable[])m.invoke(sortObj, t.getParams())));
						}
						else 
						assertEquals(msg, t.getResult(),(Comparable[])m.invoke(sortObj, t.getParams()));
					}
					clearTestCases();
				}
			}
		}
	}
	
	/*public void testAllSort() throws IllegalArgumentException, IllegalAccessException{
		SortTest obj=new SortTest();
		Field[] fields=SortTest.class.getDeclaredFields();
		int caseIndex=0;
		for(Field f:fields){
			if(f.get(obj) instanceof ISort){
				ISort sortObj=(ISort) f.get(obj);
				for(TestCase t:testCases){
					String msg="Class: "+sortObj.getClass().getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
					//Deal with null
					if(t.getParams()[0]==null)assertTrue("null case", sortObj.sort(null)==null);
					//Deal with arrays, compare each element, or use toString and compare the String
					else if(t.getResult() instanceof Comparable[]){ //Cannot use ==Comparable[].class, return Integer[] actually
						assertEquals(msg,Arrays.toString((Comparable[])t.getResult()),Arrays.toString(sortObj.sort((Comparable[])t.getParams()[0])));
						Comparable[] r=(Comparable[])t.getResult();
						Comparable[] actual=sortObj.sort((Comparable[])t.getParams()[0]);
						assertEquals("length not equal", r.length, actual.length);
						for(int i=0;i<r.length;i++){
							assertEquals(msg+i, r[i],actual[i]);
						}
					}
					else 
					assertEquals(msg, t.getResult(),sortObj.sort((Comparable[])t.getParams()[0]));
				}
			}
		}
	}*/
	
	@After
	public void clearTestCases(){
		testCases.clear();
	}
	

}
