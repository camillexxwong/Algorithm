package cawang.xyati.tools;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RandomNumbersTest {

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testGenerateRandomNumbers() {
		Object[] objs=(Object[])null;
		//[]
		System.out.println("Params: 3, 10, 9, true []; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 10, 9, true)));
		System.out.println("Params: 3, 10, 9, false; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 10, 9, false)));
		System.out.println("Params: 3, 20, 12, true; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 20, 12, true)));
		System.out.println("Params: 3, 20, 12, false; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 20, 12, false)));
		System.out.println("Params: 3, 30, 28, true; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 30, 28, true)));
		System.out.println("Params: 3, 30, 28, false; "+Arrays.toString(RandomNumbers.generateRandomInts(3, 30, 28, false)));
		//[]
		System.out.println("Params: 0, 0, 0, true []; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 0, true)));
		//[]
		System.out.println("Params: 0, 0, 0, false []; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 0, false)));
		//[0]
		System.out.println("Params: 0, 0, 1, true [0]; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 1, true)));
		//[0]
		System.out.println("Params: 0, 0, 1, false [0]; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 1, false)));
		//[]
		System.out.println("Params: 0, 0, 2, true []; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 2, true)));
		//[0, 0]
		System.out.println("Params: 0, 0, 2, false [0, 0]; "+Arrays.toString(RandomNumbers.generateRandomInts(0, 0, 2, false)));
		//[]
		System.out.println("Params: 1, 2, -1, true []; "+Arrays.toString(RandomNumbers.generateRandomInts(1, 2, -1, true)));
		//[]
		System.out.println("Params: 1, 2, -1, false []; "+Arrays.toString(RandomNumbers.generateRandomInts(1, 2, -1, false)));
		//[]
		System.out.println("Params: 10, 5, 7, true []; "+Arrays.toString(RandomNumbers.generateRandomInts(10, 5, 7, true)));
		//[]
		System.out.println("Params: 10, 5, 7, false []; "+Arrays.toString(RandomNumbers.generateRandomInts(10, 5, 7, false)));
		System.out.println("Params: -10, -1, 9, true; "+Arrays.toString(RandomNumbers.generateRandomInts(-10, -1, 9, true)));
		System.out.println("Params: -10, -1, 9, false; "+Arrays.toString(RandomNumbers.generateRandomInts(-10, -1, 9, false)));
		int[] array=RandomNumbers.generateRandomInts(-10, 10, 21, true);
		Arrays.sort(array);
		System.out.println("Params: -10, 10, 21, true; "+Arrays.toString(array));
		System.out.println("Params: -10, 10, 21, false; "+Arrays.toString(RandomNumbers.generateRandomInts(-10, 10, 21, false)));
		  
		Random r=new java.util.Random(10); 
		  for(int i=0;i<10;i++){ 
		    System.out.print(r.nextInt()+"; "); 
		  } 
		  System.out.println("\n");
	}
	@Test
	public void testGetRandomInt() {
		//Case1
		System.out.print("testGetRandomInt, Params: 3, 10; [");
		for(int i=0;i<30;i++){
			int random=RandomNumbers.generateRandomInt(3, 10);
			System.out.print(random+",");
			assertTrue(random>=3&&random<=10);
		}
		System.out.println("]");
		
		//Case2
		System.out.print("testGetRandomInt, Params: -10, -1; [");
		for(int i=0;i<30;i++){
			int random=RandomNumbers.generateRandomInt(-10, -1);
			System.out.print(random+",");
			//assertTrue(random>=-20&&random<=-1);
		}
		System.out.println("]");
		
		//Case3
		System.out.print("testGetRandomInt, Params: -10, 10; [");
		for(int i=0;i<30;i++){
			int random=RandomNumbers.generateRandomInt(-10, 10);
			System.out.print(random+",");
			//assertTrue(random>=-10&&random<=10);
		}
		System.out.println("]");
	}
}
