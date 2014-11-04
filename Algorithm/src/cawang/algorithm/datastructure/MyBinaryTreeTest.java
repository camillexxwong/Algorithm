package cawang.algorithm.datastructure;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class MyBinaryTreeTest {
	public class TestCaseTraverse implements ITestCase{
		MyBinaryTree tree;
		String result;
		TestCaseTraverse(MyBinaryTree tree, String result){
			this.tree=tree;
			this.result=result;
		}
		@Override
		public Object[] getParams() {
			// TODO Auto-generated method stub
			MyBinaryTree[] params={tree};
			return params;
		}

		@Override
		public Object getResult() {
			// TODO Auto-generated method stub
			return result;
		}
		

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "TestCase: "+result;
		}
		
		
	}
	MyBinaryTree obj=new MyBinaryTree();
	
	ArrayList<TestCaseTraverse> testCaseTraversesPres=new ArrayList<TestCaseTraverse>();
	ArrayList<TestCaseTraverse> testCaseTraversesIns=new ArrayList<TestCaseTraverse>();
	ArrayList<TestCaseTraverse> testCaseTraversesPosts=new ArrayList<TestCaseTraverse>();
	static ArrayList<Integer[]> sequencePres=new ArrayList<Integer[]>(10);
	static ArrayList<String> resultPres=new ArrayList<String>(10);
	static ArrayList<Integer[]> sequenceIns=new ArrayList<Integer[]>(10);
	static ArrayList<String> resultIns=new ArrayList<String>(10);
	static ArrayList<Integer[]> sequencePosts=new ArrayList<Integer[]>(10);
	static ArrayList<String> resultPosts=new ArrayList<String>(10);
	@BeforeClass
	public static void init()throws Exception {
		//Pre
		Integer[] pre1=new Integer[]{0,1,2,3,-1,-1,4,-1,-1,5,-1,-1,6,7,8,-1,-1,-1,9,-1,-1};
		String resultPre1="0123nn4nn5nn678nnn9nn";
		sequencePres.add(convertS(resultPre1));
		resultPres.add(resultPre1);
		sequencePres.add(null);
		resultPres.add("n");
		sequencePres.add(new Integer[]{-1});
		resultPres.add("n");
		sequencePres.add(new Integer[]{1});
		resultPres.add("1nn");
		sequencePres.add(new Integer[]{1,-1,-1});
		resultPres.add("1nn");
		
		//In
		Integer[] in1=new Integer[]{-1,0,-1,1,-1,2,-1,3,-1,4,-1,5,-1,6,-1,7,-1,8,-1,9,-1};
		String resultIn1="n0n1n2n3n4n5n6n7n8n9n";
		sequenceIns.add(in1);
		resultIns.add(convertN(in1));
		sequenceIns.add(null);
		resultIns.add("n");
		sequenceIns.add(new Integer[]{-1});
		resultIns.add("n");
		sequenceIns.add(new Integer[]{1});
		resultIns.add("n1n");
		sequenceIns.add(new Integer[]{-1,1,-1});
		resultIns.add("n1n");
		
		//Post
		String resultPost1="nn0nn12nn34nn5n6nn789";
		//[-1, -1, 0, -1, -1, 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, 6, -1, -1, 7, 8, 9]
		sequencePosts.add(convertS(resultPost1));
		resultPosts.add(resultPost1);
		sequencePosts.add(null);
		resultPosts.add("n");
		sequencePosts.add(new Integer[]{-1});
		resultPosts.add("n");
		sequencePosts.add(new Integer[]{1});
		resultPosts.add("nn1");
		sequencePosts.add(new Integer[]{-1,-1,1});
		resultPosts.add("nn1");
		
		
	}
	private static String convertN(Integer[] numbers){
		StringBuilder str=new StringBuilder("");
		for(Integer n:numbers){
			if(n==-1)str.append("n");
			else str.append(n);
		}
		return str.toString();
	}
	private static Integer[] convertS(String s){
		Integer[] numbers=new Integer[s.length()];
	
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='n')numbers[i]=-1;
			else numbers[i]=Integer.valueOf(c)-48; //ASCII
		}
		return numbers;
	}
	@Before
	public void setUp() throws Exception {
		//Pre
		for(int i=0;i<sequencePres.size();i++){
			MyBinaryTree<Integer> treePreTemp=obj.makeTreePre(sequencePres.get(i));
			testCaseTraversesPres.add(new TestCaseTraverse(treePreTemp,resultPres.get(i)));
		}
		
		//In
		for(int i=0;i<sequenceIns.size();i++){
			MyBinaryTree<Integer> treeIn=obj.makeTreeIn(sequenceIns.get(i));
			testCaseTraversesIns.add(new TestCaseTraverse(treeIn,resultIns.get(i)));
		}
		
		
		
		
		//Pre
/*		MyBinaryTree<Integer> treePre1;
		Integer[] sequencePre1={0,1,2,3,-1,-1,4,-1,-1,5,-1,-1,6,7,8,-1,-1,-1,9,-1,-1};
		String resultPre1= "0123nn4nn5nn678nnn9nn";
		treePre1=obj.makeTreePre(sequencePre1,new Integer[]{0});
		TestCaseTraverse testCaseTraversesPre1=new TestCaseTraverse(treePre1,resultPre1);
		
		MyBinaryTree<Integer> treePre2;
		Integer[] sequencePre2=null;
		String resultPre2= "n";
		treePre2=obj.makeTreePre(sequencePre2,new Integer[]{0});
		TestCaseTraverse testCaseTraversesPre2=new TestCaseTraverse(treePre2,resultPre2);
		
		MyBinaryTree<Integer> treePre3;
		Integer[] sequencePre3={-1};
		String resultPre3= "n";
		treePre3=obj.makeTreePre(sequencePre3,new Integer[]{0});
		TestCaseTraverse testCaseTraversesPre3=new TestCaseTraverse(treePre3,resultPre3);
		
		MyBinaryTree<Integer> treePre4;
		Integer[] sequencePre4={1};
		String resultPree4= "1nn";
		treePre4=obj.makeTreePre(sequencePre4,new Integer[]{0});
		TestCaseTraverse testCaseTraversesPre4=new TestCaseTraverse(treePre4,resultPree4);
		
		
		testCaseTraversesPres.add(testCaseTraversesPre1);
		testCaseTraversesPres.add(testCaseTraversesPre2);
		testCaseTraversesPres.add(testCaseTraversesPre3);
		testCaseTraversesPres.add(testCaseTraversesPre4);*/
		
		//In
		
		
	}
	
	@Test
	public void testPre() throws Exception {
		Method method1=obj.getClass().getDeclaredMethod("preOrderTraverse", MyBinaryTree.class);
		Method method2=obj.getClass().getDeclaredMethod("preOrderTraverseNonRecursive", MyBinaryTree.class);
		for(int i=0;i<testCaseTraversesPres.size();i++){
			TestCaseTraverse t=testCaseTraversesPres.get(i);
			//System.out.println(t.getResult());
			assertEquals(method1.getName()+" "+i,t.getResult(),method1.invoke(obj, t.getParams()));
			assertEquals(method2.getName()+" "+i,t.getResult(),method2.invoke(obj, t.getParams()));
		}
	}
	
	@Test
	public void testIn() throws Exception {
		Method method1=obj.getClass().getDeclaredMethod("inOrderTraverse", MyBinaryTree.class);
		Method method2=obj.getClass().getDeclaredMethod("inOrderTraverseNonRecursive", MyBinaryTree.class);
		for(int i=0;i<testCaseTraversesIns.size();i++){
			TestCaseTraverse t=testCaseTraversesIns.get(i);
			//System.out.println(t.getResult());
			assertEquals(method1.getName()+" "+i,t.getResult(),method1.invoke(obj, t.getParams()));
			assertEquals(method2.getName()+" "+i,t.getResult(),method2.invoke(obj, t.getParams()));
		}
	}
	@Test
	public void t(){
		String s="nn0nn12nn34nn5n6nn789";
		System.out.println(Arrays.toString(convertS(s)));
	}
}
