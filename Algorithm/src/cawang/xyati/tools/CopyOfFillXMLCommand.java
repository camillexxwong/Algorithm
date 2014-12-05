package cawang.xyati.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CopyOfFillXMLCommand {
	//pre-defined all parameter types
	public final static int DICTIONARY_PARAMTYPE_ATTIRBUTE=1;
	public final static int DICTIONARY_PARAMTYPE_METRIC=2;
	
	//pre-defined whildcard (prefix)
	public final static String regex="%%";
	
	//Input: pre-defined command pattern
	private String commandPattern="command3: param: %%1, param: %%2, param: %%2, param: %%1, param: %%2, %1, %%4,%%";

	//Input: random parameters output
	private List<String> allMetrics=(List<String>) Arrays.asList(new String[]{"Revenue","Cost","Profit","Price"});
	private List<String> allAttributes=(List<String>) Arrays.asList(new String[]{"Year","Quarter","Month","Day","Category"});	
	
	//Input: paramList
	private HashMap<Integer,Integer> paramsCountMap=new HashMap<Integer,Integer>();
	
	private HashMap<Integer,List<String>> paramsObjectMap=new HashMap<Integer,List<String>>();
	
	//Initialization
	public CopyOfFillXMLCommand(){
		//should be prepared by previous actions
		paramsCountMap.put(DICTIONARY_PARAMTYPE_ATTIRBUTE,2);
		paramsCountMap.put(DICTIONARY_PARAMTYPE_METRIC,3);
		
		//init
		paramsObjectMap.put(DICTIONARY_PARAMTYPE_ATTIRBUTE, allAttributes);
		paramsObjectMap.put(DICTIONARY_PARAMTYPE_METRIC, allMetrics);
	}
	public String fillXMLCmd(){
		StringBuffer command=new StringBuffer("");
		HashMap<Integer, Integer> indexMap=new HashMap<Integer, Integer>();
		for(int i=0;i<commandPattern.length();i++){
			if(commandPattern.regionMatches(i, regex, 0, regex.length())){
				if(paramsCountMap==null||paramsObjectMap==null) return commandPattern;//error
				i+=regex.length();
				int endIdx=commandPattern.indexOf(regex, i);
				if(endIdx==-1||i>commandPattern.length()-1) return command.toString(); //error
				int type=commandPattern.charAt(i)-'0';
				String param;
				//Illegal type, roll back, don't replace
				if(paramsCountMap.get(type)==null||paramsObjectMap.get(type)==null){
					command.append(regex);
					command.append(type);
					continue;
				}
				if(!indexMap.containsKey(type))indexMap.put(type, 0);
				int idx=indexMap.get(type);
				param=paramsObjectMap.get(type).get(idx);
				indexMap.put(type, idx+1);
				command.append(param);
				i=endIdx+regex.length();
			}
			else{
				command.append(commandPattern.charAt(i));
			}
		}
		return command.toString();
	}
	
/*	public String fillXMLCmd(){
		StringBuffer command=new StringBuffer("");
		HashMap<Integer, Integer> indexMap=new HashMap<Integer, Integer>();
		for(int i=0;i<commandPattern.length();i++){
			if(commandPattern.regionMatches(i, regex, 0, regex.length())){
				i+=regex.length();
				int type=commandPattern.charAt(i)-'0';
				String param;
				switch(type){
					case DICTIONARY_PARAMTYPE_ATTIRBUTE:
						if(!indexMap.containsKey(type))indexMap.put(type, 0);
						int idx=indexMap.get(type);
						param=allAttributes.get(idx);
						indexMap.put(type, idx+1);
						command.append(param);
						break;
					case DICTIONARY_PARAMTYPE_METRIC:
						if(!indexMap.containsKey(type))indexMap.put(type, 0);
						int idx2=indexMap.get(type);
						param=allMetrics.get(idx2);
						indexMap.put(type, idx2+1);
						command.append(param);
						break;	
					default:
						command.append(regex);
						command.append(type);
						break;
				}
				
			}
			else{
				command.append(commandPattern.charAt(i));
			}
		}
		return command.toString();
	}*/

}
