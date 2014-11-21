package cawang.xyati.tools;

import java.util.Arrays;
import java.util.Hashtable;


public class RandomXMLPrototype {
	//pre-defined command pattern
	public final static String DICTIONARY_COMMAND_TEST1="command1: param: %, param: %";
	public final static String DICTIONARY_COMMAND_TEST2="command2: param: %";
	public final static String DICTIONARY_COMMAND_TEST3="command3: param: %, param: %, param: %, parma: %";
	//pre-defined all parameter types
	public final static int DICTIONARY_PARAMTYPE_ATTIRBUTE=1;
	public final static int DICTIONARY_PARAMTYPE_METRIC=2;
	
	//These objs should be passed dynamically
	private String[] allMetrics=new String[]{"Revenue","Cost","Profit","Price"};
	private String[] allAttributes=new String[]{"Year","Quarter","Month","Day","Category"};
	
	/**
	 * A Dictionary that stores mappings between XML Command Pattern and required parameters' types 
	 */
	public Hashtable<String, Integer[]> XMLcmdTable;
	public Hashtable<Integer, String[]> paramsTable;
	
	public RandomXMLPrototype(){
		XMLcmdTable=new Hashtable<String, Integer[]>();
		paramsTable=new Hashtable<Integer, String[]>();
		//need to be improved
		XMLcmdTable.put(DICTIONARY_COMMAND_TEST1, new Integer[]{DICTIONARY_PARAMTYPE_METRIC,DICTIONARY_PARAMTYPE_ATTIRBUTE});
		XMLcmdTable.put(DICTIONARY_COMMAND_TEST2, new Integer[]{DICTIONARY_PARAMTYPE_ATTIRBUTE});
		XMLcmdTable.put(DICTIONARY_COMMAND_TEST3, new Integer[]{DICTIONARY_PARAMTYPE_ATTIRBUTE,DICTIONARY_PARAMTYPE_METRIC,DICTIONARY_PARAMTYPE_METRIC,DICTIONARY_PARAMTYPE_ATTIRBUTE});
		
		paramsTable.put(DICTIONARY_PARAMTYPE_ATTIRBUTE, allAttributes);
		paramsTable.put(DICTIONARY_PARAMTYPE_METRIC, allMetrics);
	}
	public String generateRandomXMLCmd(){
		StringBuffer XMLCmd=new StringBuffer("");
		//1) generate a random command pattern
		String cmdPattern=getRandomComandPattern();
		//2) get random parameters that qualify the command
		Integer[] paramTypes=XMLcmdTable.get(cmdPattern);
		String[] params=getRandomParamsForXMLCmd(paramTypes);
		//3) fill in the command pattern with parameters
		return fillCmd(cmdPattern,params);
	}
	/**
	 * Given parameter types list, get random parameters that fit the types
	 * @param cmdPattern
	 * @return
	 */
	private String[] getRandomParamsForXMLCmd(Integer[] paramTypes){
		String[] params=new String[paramTypes.length];
		for(int i=0;i<params.length;i++){
			params[i]=getRandomParam(paramTypes[i]);
		}
		return params;
	}
	
	/**
	 * Pick a random XML Command Pattern from XMLCmdTable
	 * @return
	 */
	private String getRandomComandPattern(){
		Object[] patternsStrings=XMLcmdTable.keySet().toArray();
		int random=getRandomInt(patternsStrings.length);
		return (String)patternsStrings[random];
	}
	/**
	 * Get a random parameter of specified parameter type
	 * @param paramType The specified parameter type
	 * @return Parameter for XML Command
	 */
	private String getRandomParam(int paramType) {
		String[] paramList=paramsTable.get(paramType);
		int random=getRandomInt(paramList.length);
		return paramList[random];
	}
	/**
	 * Fill a XML Command including wild-card ("%") with specific parameters
	 * @param cmdPattern An pre-defined XML Command pattern with some wild-cards
	 * @param params The actual parameters to replace wild-cards
	 * @return XML Command
	 */
	private String fillCmd(String cmdPattern, String...params){
		StringBuffer command=new StringBuffer(cmdPattern);
		String regex="%";
		for(String s:params){
			cmdPattern=cmdPattern.replaceFirst(regex, s);
		}
		return cmdPattern.toString();
	}
	/**
	 * Generate a random integer between 0 and range
	 * @param range
	 * @return
	 */
	private int getRandomInt(int range){
		return (int)(Math.random()*range);
	}
	public static void main(String[] args){
		RandomXMLPrototype obj=new RandomXMLPrototype();
		System.out.println(obj.generateRandomXMLCmd());
	}
}
