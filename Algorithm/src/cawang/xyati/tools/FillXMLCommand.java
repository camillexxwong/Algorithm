package cawang.xyati.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FillXMLCommand {
	//pre-defined all parameter types
	public final static String DICTIONARY_PARAMTYPE_ATTIRBUTE="attr";
	public final static String DICTIONARY_PARAMTYPE_METRIC="metric";
	
	//pre-defined whildcard (prefix)
	public final static String regex="%%";
	
	//Input: pre-defined command pattern
	private String commandPattern="command3: param: %%attr%%, param: %%metric%%, param: %%metric%%, param: %%attr%%, param: %%metric%%, %attr, %%4%%,%%";

	//Input: random parameters output
	private List<String> allMetrics=(List<String>) Arrays.asList(new String[]{"Revenue","Cost","Profit","Price"});
	private List<String> allAttributes=(List<String>) Arrays.asList(new String[]{"Year","Quarter","Month","Day","Category"});	
	
	//Input: paramList
	private HashMap<String,Integer> paramsCountMap=new HashMap<String,Integer>();
	
	private HashMap<String,List<String>> paramsObjectMap=new HashMap<String,List<String>>();
	
	//Initialization
	public FillXMLCommand(){
		//should be prepared by previous actions
		paramsCountMap.put(DICTIONARY_PARAMTYPE_ATTIRBUTE,2);
		paramsCountMap.put(DICTIONARY_PARAMTYPE_METRIC,3);
		
		//init
		paramsObjectMap.put(DICTIONARY_PARAMTYPE_ATTIRBUTE, allAttributes);
		paramsObjectMap.put(DICTIONARY_PARAMTYPE_METRIC, allMetrics);
	}
	public String fillXMLCmd(){
		StringBuffer command=new StringBuffer("");
		HashMap<String, Integer> indexMap=new HashMap<String, Integer>();
		for(int i=0;i<commandPattern.length();i++){
			if(commandPattern.regionMatches(i, regex, 0, regex.length())){
				if(paramsCountMap==null||paramsObjectMap==null) return commandPattern;//error
				i+=regex.length();
				int endMarkIdx=commandPattern.indexOf(regex, i);
				if(endMarkIdx==-1||i>commandPattern.length()-1) return command.toString(); //error
				//int type=commandPattern.charAt(i)-'0';
				String type=commandPattern.substring(i,endMarkIdx);
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
				i=endMarkIdx+regex.length();
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
