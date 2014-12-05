/*package cawang.xyati.action;

import java.util.HashMap;

import com.microstrategy.yati.Action;
import com.microstrategy.yati.ActionContextInterface;
import com.microstrategy.yati.EnumYatiTestResults;
import com.microstrategy.yati.StateContainer;
import com.microstrategy.yatilibrary.Constants;
import com.microstrategy.yatilibrary.Utils;

*//**
 * Generate a parameter count map for given XML Command Pattern
 * Put the count values of each type directly to state container
 * @author cawang
 *
 *//*
public class GetParametersCount extends Action{
	private StateContainer initialization;
	
	@Override
	public int initialize(StateContainer parameters,
			ActionContextInterface actionContext) throws Exception {
		initialization=parameters;
		return EnumYatiTestResults.Ok;
	}

	@Override
	public int execute(StateContainer state,
			ActionContextInterface actionContext) throws Exception {
		if(state==null){
			Utils.logMessage("Info", "State Container is null",actionContext);
			return EnumYatiTestResults.Abort;
		}
		//Get Inputs
		String xmlCmdPattern=(String)state.get(Constants.STR_XML_COMMAND_PATTERN);
		String regex=Utils.getParameter(Constants.STR_WILDCARD, initialization, state, "%");
		//Check XML Command Patter
				if(xmlCmdPattern==null||xmlCmdPattern==""){
					Utils.logMessage("Info", "XML Command Pattern is null or empty",actionContext);
					return EnumYatiTestResults.Abort;
				}
		//Output
		//HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		
		for(int i=0;i<xmlCmdPattern.length();i++){
			if(xmlCmdPattern.regionMatches(i, regex, 0, regex.length())){
				i+=regex.length();
				int endMarkIdx=xmlCmdPattern.indexOf(regex, i);
				//If no parameters after wild-card, abort 
				if(endMarkIdx==-1){
					Utils.logMessage("Info", "End mark of wildcard not found in XML Command Pattern",actionContext);
					return EnumYatiTestResults.Abort;
				}
				String type=xmlCmdPattern.substring(i,endMarkIdx);
				//check type
				//TODO
				if(!state.containsKey(type))state.put(type, 0);
				else state.put("intCount" + type, (Integer)state.get(type) + 1 );
				i=endMarkIdx+regex.length();
			}
		}
		//state.put(Constants.MAP_PARAMETERS_COUNT, map);
		return EnumYatiTestResults.Ok;
	}
}
*/