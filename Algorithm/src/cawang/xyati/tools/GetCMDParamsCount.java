package cawang.xyati.tools;

import java.util.HashMap;
import java.util.Map;

public class GetCMDParamsCount {//pre-defined all parameter types
	public final static String DICTIONARY_PARAMTYPE_ATTIRBUTE="attr";
	public final static String DICTIONARY_PARAMTYPE_METRIC="metric";
	//Input: pre-defined command pattern
	//{=0, metric=2, 4=0, attr=1}
	private String commandPattern="command3: param: %%attr%%, param: %%metric%%, param: %%metric%%, param: %%attr%%, param: %%metric%%, %attr, %%4%%,%%%%";
	public final static String regex="%%";
	
	public HashMap<String, Integer> getParamCountMap(){
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<commandPattern.length();i++){
			if(commandPattern.regionMatches(i, regex, 0, regex.length())){
				i+=regex.length();
				int endMarkIdx=commandPattern.indexOf(regex, i);
				if(endMarkIdx==-1||i>commandPattern.length()-1) return null; //error
				String type=commandPattern.substring(i,endMarkIdx);
				if(!map.containsKey(type))map.put(type, 0);
				else map.put(type, map.get(type)+1);
				i=endMarkIdx+regex.length();
			}
		}
		return map;
	}
	public static void main(String[] args){
		GetCMDParamsCount obj=new GetCMDParamsCount();
		HashMap result=obj.getParamCountMap();
		System.out.println(result==null);
		System.out.println(result.toString());
	}
	
}
