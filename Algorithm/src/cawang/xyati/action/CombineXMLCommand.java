/*package cawang.xyati.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microstrategy.yati.Action;
import com.microstrategy.yati.ActionContextInterface;
import com.microstrategy.yati.EnumYatiTestResults;
import com.microstrategy.yati.StateContainer;
import com.microstrategy.yatilibrary.Constants;
import com.microstrategy.yatilibrary.Utils;
import com.sun.corba.se.impl.orbutil.closure.Constant;

*//**
 * Fill a XML Command pattern with wild-card with actual parameters
 * Input: STR_XML_COMMAND_PATTERN, STR_WILDCARD, MAP_PARAMETERS_COUNT, MAP_PARAMETERS_TYPE
 * Output: A legal XML Command 
 * @author cawang
 *
 *//*
public class CombineXMLCommand extends Action {
	private StateContainer initialization;
	
	//pre-defined all parameter types
	//Used by paramsCountMap and paramsObjectMap, as map key; and in XML Command Pattern, such as %1
	public final static int DICTIONARY_PARAMTYPE_ATTIRBUTE=1;
	public final static int DICTIONARY_PARAMTYPE_METRIC=2;
	
	
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
		//Get Inputs from state container
		paramsCountMap is set by getParamsList Action
		  paramsObjectMap is set by each addParamsToMap Action
		String xmlCmdPattern=(String)state.get(Constants.STR_XML_COMMAND_PATTERN);
		String regex=Utils.getParameter(Constants.STR_WILDCARD, initialization, state, "%");
		//Map<String,Integer> paramsCountMap=(Map<String,Integer>)state.get(Constants.MAP_PARAMETERS_COUNT);
		String strBagName = state.getStringValue("strBagName");
		ArrayList bag=(ArrayList)state.get(strBagName);
		//Map<String,List<String>> paramsObjectMap=(Map<String,List<String>>)bag.get(0);
		StateContainer paramsObjectMap=(StateContainer)bag.get(0);
		//Check XML Command Patter
		if(xmlCmdPattern==null||xmlCmdPattern==""){
			Utils.logMessage("Info", "XML Command Pattern is null or empty",actionContext);
			return EnumYatiTestResults.Abort;
		}
		//begin to fill command with actual parameters
		variable command is output
		indexMap indicates the current index of each type of parameters
		StringBuffer command=new StringBuffer("");
		HashMap<String, Integer> indexMap=new HashMap<String, Integer>();
		for(int i=0;i<xmlCmdPattern.length();i++){
			//find wild-cards
			if(xmlCmdPattern.regionMatches(i, regex, 0, regex.length())){
				i+=regex.length();
				int endMarkIdx=xmlCmdPattern.indexOf(regex, i);
				//If no parameters after wild-card, abort 
				if(endMarkIdx==-1){
					Utils.logMessage("Info", "End mark of wildcard not found in XML Command Pattern",actionContext);
					return EnumYatiTestResults.Abort;
				}
				//check map, if parameters maps are empty, abort
				if(paramsObjectMap==null) {
					Utils.logMessage("Info", Constants.MAP_PARAMETERS_TYPE + " is null",actionContext);
					return EnumYatiTestResults.Abort;
				}
				String type=xmlCmdPattern.substring(i,endMarkIdx);
				//If parameter type is not found in parameters map, abort
				if(paramsObjectMap.get(type)==null){
					Utils.logMessage("Info", "Illegal parameter types in XML Command Pattern",actionContext);
					return EnumYatiTestResults.Abort;
				}
				if(!indexMap.containsKey(type))indexMap.put(type, 0);
				int idx=indexMap.get(type);
				String param;
				try {
					param = (String)((ArrayList)paramsObjectMap.get(type)).get(idx);
				} catch (ArrayIndexOutOfBoundsException e) {
					//If parameter list (as the value of mapParamsType) contains less elements than needed, abort
					Utils.logMessage("Info", "Parameter List Type"+type+" contains less elements than XML Command needed",actionContext);
					return EnumYatiTestResults.Abort;
				}
				
				indexMap.put(type, idx+1);
				command.append(param);
				i=endMarkIdx+regex.length();
			}
			else{
				command.append(xmlCmdPattern.charAt(i));
			}
		}
		state.put(Constants.STR_XML_COMMAND, command.toString());
		return EnumYatiTestResults.Ok;
	}
	

}
*/