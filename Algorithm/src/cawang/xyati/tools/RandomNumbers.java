package cawang.xyati.tools;

import java.util.Arrays;

public class RandomNumbers {
	/**
	 * Given a range, generate random numbers
	 * @param low the lower bound
	 * @param high the upper bound
	 * @param count how many numbers to generate
	 * @param isDistinct need distinct random numbers or not
	 * @return return empty array instead of null if parameters are illegal
	 */
	public static int[] generateRandomInts(int low, int high, int count, boolean isDistinct){
		return isDistinct?generateDistinctRandomInts(low,high,count)
				:generateNonDistinctRandomInts(low,high,count);
	}
	/**
	 * Given a range, generate distinct random numbers
	 * Time: O(n*logN)
	 * Space: O(n)
	 * @param low the lower bound
	 * @param high the upper bound
	 * @param count how many numbers to generate
	 * @return return empty array instead of null if parameters are illegal
	 */
	private static int[] generateDistinctRandomInts_1(int low, int high, int count){
		if(count<0||low>high||count>(high-low+1)) return new int[0];
		int[] randoms=new int[count];
		boolean[] marks=new boolean[high-low+1];
		for(int i=0;i<count;i++){
			int random;
			do{
				random=generateRandomInt(low,high);
			}while(marks[random-low]==true);
			marks[random-low]=true;
			randoms[i]=random;
		}
		return randoms;
		
	}
	/**
	 * Given a range, generate distinct random numbers
	 * Time: O(n)
	 * Space: O(n)
	 * @param low the lower bound
	 * @param high the upper bound
	 * @param count how many numbers to generate
	 * @return return empty array instead of null if parameters are illegal
	 */
	private static int[] generateDistinctRandomInts(int low, int high, int count){
		if(count<0||low>high||count>(high-low+1)) return new int[0];
		int[] sources=new int[high-low+1];
		int[] randoms=new int[count];
		for(int i=0;i<high-low+1;i++){
			sources[i]=i+low;
		}
		for(int i=0;i<count;i++,high--){
			int randomIdx=generateRandomInt(0,high-low);
			randoms[i]=sources[randomIdx];
			sources[randomIdx]=sources[high-low];
		}
		return randoms;
		
	}
	/**
	 * Given a range, generate random numbers, no limit of distinct or not
	 * @param low the lower bound
	 * @param high the upper bound
	 * @param count how many numbers to generate
	 * @return return empty array instead of null if parameters are illegal
	 */
	private static int[] generateNonDistinctRandomInts(int low, int high, int count){
		if(count<0||low>high) return new int[0];
		int[] randoms=new int[count];
		for(int i=0;i<count;i++){
			randoms[i]=generateRandomInt(low,high);
		}
		return randoms;
	}
	
	/**
	 * Generate a random integer between low and high
	 * Need to guarantee high>=low when call this, otherwise will return a number between [high+1,low-1]
	 * low and high can be negative
	 * @param low the lower bound
	 * @param high the upper bound
	 * @return
	 */
	public static int generateRandomInt(int low,int high){
		return (int)(Math.random()*(high-low+1)) + low; //random->*range->cast to int->+low
	}
}
