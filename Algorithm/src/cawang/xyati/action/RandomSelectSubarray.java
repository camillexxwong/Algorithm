/*package cawang.xyati.action;

import java.util.ArrayList;

import com.microstrategy.yati.Action;
import com.microstrategy.yati.ActionContextInterface;
import com.microstrategy.yati.EnumYatiTestResults;
import com.microstrategy.yati.StateContainer;
import com.microstrategy.yatilibrary.Constants;
import com.microstrategy.yatilibrary.Utils;
*//**
 * Generate a random sub-array of the given object array, with a given number as the sub-array's size
 * Input: an array of Objects, sub-array size, distinct flag
 * Output: a random sub-array
 * Parameters: strArrayName, strOutputName, intRandomCount, isDistinct
 * output: strOutputArray
 * @author cawang
 *
 *//*
public class RandomSelectSubarray extends Action {
	private StateContainer initialization;
	
	@Override
	public int initialize(StateContainer parameters,
			ActionContextInterface actionContext) throws Exception {
		initialization=parameters;
		return EnumYatiTestResults.Ok;
	}

	//check state? randomNumbers
	@Override
	public int execute(StateContainer state,
			ActionContextInterface actionContext) throws Exception {
		if(state==null){
			Utils.logMessage("Info", "State Container is null",actionContext);
			return EnumYatiTestResults.Abort;
		}
		//Get input parameter names from initialization
		String strArrayName = Utils.getParameter(Constants.STR_ARRAY_NAME, initialization, state, Constants.ARR_OBJECTS);
		String strOutputName=Utils.getParameter(Constants.STR_OUTPUT_NAME, initialization, state, Constants.ARR_OBJECTS);
		
		//Get inputs from state container: the source object array, random counts, is distinct randam array
		ArrayList<Object> sourceObjects=(ArrayList<Object>) state.get(strArrayName);
		int intRandomCount=(Integer)state.get(intRandomCountName);
		boolean isDistinct=(Boolean)state.get(isDistinctName);
		int intRandomCount=Utils.getParameter(Constants.INT_RANDOM_NUMBER_COUNT, initialization, state, 1);
		boolean isDistinct=Utils.getParameter(Constants.B_IS_DISTINCT, initialization, state, true);
		
		//if source array is null, abort, return abort+1, can try to generate again again in scenario
		if(sourceObjects==null){
			Utils.logMessage("Info", "No such Array found in the StateContainer: " + strArrayName,actionContext);
			return EnumYatiTestResults.Abort + 1;
		}
		
		//initialize the output
		ArrayList<Object> randomObjects=new ArrayList<Object>(intRandomCount);
		//generate an array of random numbers
		int[] randomNumbers=RandomNumbers.generateRandomInts(0, sourceObjects.size()-1, intRandomCount, isDistinct);
		//If the parameters are illegal(length==0,randomCount>length,etc.), return abort+2, can try to generate again again in scenario
		//Assert randomNumbers!=null, randomNumbers.length=intRandomCount
		if(randomNumbers.length==0) {
			Utils.logMessage("Info", "Source Array is empty or Parameters are illegal (" + "Source Array: "+strArrayName
					+"Source Array Length: "+sourceObjects.size()+"Random Objects Count:+ "+intRandomCount
					+"isDistinct:" +isDistinct+")",actionContext);
			return EnumYatiTestResults.Abort + 2;
		}
		//generate sub-array as output 
		for(int i=0;i<intRandomCount;i++){
			randomObjects.add(sourceObjects.get(randomNumbers[i]));
		}
		//Put outputs to state container
		state.put(strOutputName, randomObjects);
		return EnumYatiTestResults.Ok;
	}

}
*/