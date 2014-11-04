package cawang.algorithm.datastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class MyBinaryTree<T> {
	private MyBinaryTree<T> leftChild;
	private MyBinaryTree<T> rightChild;
	T data;
	public MyBinaryTree(){
		super();
	}
	public MyBinaryTree(T t){
		this.data=t;
	}
	//Cannot use this.preOrderTraverse(), will have null pointer
	public static String preOrderTraverse(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		s.append(targetTree.data.toString());
		//System.out.println(s);
		s.append(preOrderTraverse(targetTree.leftChild));
		s.append(preOrderTraverse(targetTree.rightChild));
		return s.toString();
	}
	public static String inOrderTraverse(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		s.append(inOrderTraverse(targetTree.leftChild));
		s.append(targetTree.data.toString());
		s.append(inOrderTraverse(targetTree.rightChild));
		return s.toString();
	}
	
	public static String postOrderTraverse(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		s.append(postOrderTraverse(targetTree.leftChild));
		s.append(postOrderTraverse(targetTree.rightChild));
		s.append(targetTree.data.toString());
		return s.toString();
	}
	
	public static String preOrderTraverseNonRecursive(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		s.append(targetTree.data);
		Stack<MyBinaryTree> stack=new Stack();
		stack.push(targetTree);
		MyBinaryTree tempTree=targetTree.leftChild;
		while(!stack.empty()||tempTree!=null){
			while(tempTree!=null){
				s.append(tempTree.data);
				stack.push(tempTree);
				tempTree=tempTree.leftChild;
			}
			s.append("n");//add this to show null child
			tempTree=stack.pop();
			tempTree=tempTree.rightChild;
		}
		s.append("n");
		return s.toString();
	}
	
	public static String inOrderTraverseNonRecursive(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		Stack<MyBinaryTree> stack=new Stack();
		stack.push(targetTree);
		MyBinaryTree tempTree=targetTree.leftChild; //not neccesary, see inorderTraversal()
		while(!stack.empty()||tempTree!=null){
			while(tempTree!=null){
				stack.push(tempTree);
				tempTree=tempTree.leftChild;
			}
			s.append("n");
			tempTree=stack.pop();
			s.append(tempTree.data); //as root, just move this sentence vs. pre
			tempTree=tempTree.rightChild;
		}
		s.append("n");
		return s.toString();
	}
	//better
    public List inorderTraversal(MyBinaryTree root) {
        //if(root==null) return null;
        List result=new ArrayList();
        Stack<MyBinaryTree> stack=new Stack<MyBinaryTree>();
        MyBinaryTree temp=root;
        while(temp!=null||!stack.empty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.leftChild;
            }
            temp=stack.pop();
            result.add(temp.data);
            temp=temp.rightChild;
        }
        return result;
    }
/*	public static String preOrderTraverseNonRecursive(MyBinaryTree<?> targetTree){
		if(targetTree==null)return "n";
		StringBuilder s=new StringBuilder("");
		Stack<MyBinaryTree> stack=new Stack();
		MyBinaryTree tempTree=targetTree;
		do{
			while(tempTree.leftChild!=null){
				stack.push(tempTree);
				s.append(tempTree.data);
				tempTree=tempTree.leftChild;
				
			}
			tempTree=stack.pop();
			if(tempTree.rightChild!=null){
				tempTree=tempTree.rightChild;
				stack.push(tempTree);
				s.append(tempTree.data);
			}else if(!stack.empty()) tempTree=stack.pop();
			
		}	while(!stack.empty()&& tempTree!=null);	
		return s.toString();
	}*/
/*	public static  <T2> MyBinaryTree<T2> conversePre(T2[] sequence){
		int i=0;
		MyBinaryTree<T2> tree=new MyBinaryTree<T2>();
		while(i<=sequence.length-1&&sequence[i]==null){
			i++;
		}
		if(i>sequence.length-1)return null;
		if(sequence[i]==null&&(Integer)sequence[i]==-1)tree.data=null;
		else tree.data=sequence[i];
		sequence[i]=null;
		tree.leftChild=conversePre(sequence);
		tree.leftChild=conversePre(sequence);
		return tree;
		
	}*/
	public   <T2> MyBinaryTree<T2> makeTreePre(T2[] sequence){
		return makeTreePre(sequence,new Integer[]{0});
	}
	
	//Cannot use int as parameter type
	private   <T2> MyBinaryTree<T2> makeTreePre(T2[] sequence, Integer[] startIdx){
		
		if(sequence==null)return null;
		if(startIdx[0]>sequence.length-1)return null;
		if(sequence[startIdx[0]].equals(-1)){
			startIdx[0]=startIdx[0]+1;//important!
			return null; 
		}
		else{
			MyBinaryTree<T2> tree=new MyBinaryTree<T2>(sequence[startIdx[0]++]);
			tree.leftChild=makeTreePre(sequence,startIdx);
			tree.rightChild=makeTreePre(sequence,startIdx);
			return tree;
		}
		
	}

	
	public MyBinaryTree<Integer> makeTreeIn(Integer[] sequence) {
		int startIdx=0;
		if(sequence==null)return null;
		
		else{
			MyBinaryTree tree=createTreeNode(sequence[startIdx++]);
			while(startIdx<=sequence.length-1){
				MyBinaryTree tempRoot=new MyBinaryTree();
				tempRoot.leftChild=tree;
				tempRoot.data=sequence[startIdx++];
				tempRoot.rightChild=createTreeNode(sequence[startIdx++]);
				tree=tempRoot;
			}
			return tree;
		}
	}
	
	public MyBinaryTree<Integer> makeTreePost(Integer[] sequence) {
		return makeTreePost(sequence,new Integer[]{0});
	}
	//not implemeted
	private MyBinaryTree<Integer> makeTreePost(Integer[] sequence,Integer[] startIdx) {
		
		if(sequence==null)return null;
		else if(startIdx[0]>sequence.length-1){
			startIdx[0]++;
			return null;
		}
		else{
			MyBinaryTree tree=createTreeNode(sequence[startIdx[0]++]);
				MyBinaryTree tempRoot=new MyBinaryTree();
				tempRoot.leftChild=tree;
				tempRoot.rightChild=makeTreePost(sequence, startIdx);
				tempRoot.data=sequence[startIdx[0]];
				tree=tempRoot;
				return tree;
			}
			
	}
	
	private MyBinaryTree createTreeNode(Integer data){
		MyBinaryTree tree=new MyBinaryTree();
		if(data<0)tree=null;
		else tree=new MyBinaryTree(data);
		return tree;
	}
	
	public static void main(String args[]){
		StringBuilder s=new StringBuilder("");
		s.insert(0, "1");
		
	/*	Integer i=3;
		test(i);
		System.out.println(i);*/
		MyBinaryTree<Integer> treePre=MyBinaryTree.makeTreePre();
		//System.out.println("preOrderTraverse(treePre): "+MyBinaryTree.preOrderTraverse(treePre));
		
		
		MyBinaryTree<Integer> treeIn=makeTreeIn();
		//System.out.println("inOrderTraverse(treeIn): "+inOrderTraverse(treeIn));
		
		MyBinaryTree<Integer> treePost=makeTreePost();
		System.out.println("postOrderTraverse(treePost): "+postOrderTraverse(treePost));
		
		Integer[] sequencePre={0,1,2,3,-1,-1,4,-1,-1,5,-1,-1,6,7,8,-1,-1,-1,9,-1,-1};
		MyBinaryTree<Integer> treePreConverse=(new MyBinaryTree()).makeTreePre(sequencePre);
		System.out.println("create: makeTreePre "+preOrderTraverse(treePreConverse));
		
		Integer[] sequenceIn={-1,0,-1,1,-1,2,-1,3,-1,4,-1,5,-1,6,-1,7,-1,8,-1,9,-1};
		MyBinaryTree<Integer> treeInConverse=(new MyBinaryTree()).makeTreeIn(sequenceIn);
		System.out.println("create: makeTreeIn "+inOrderTraverse(treeInConverse));
		
		Integer[] sequencePost={-1, -1, 0, -1, -1, 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, 6, -1, -1, 7, 8, 9};
		MyBinaryTree<Integer> treePostConverse=(new MyBinaryTree()).makeTreePost(sequencePost);
		System.out.println("create: makeTreePost "+postOrderTraverse(treePostConverse));
		
		
		//System.out.println("preOrderTraverseNonRecursive: "+preOrderTraverseNonRecursive(treePre));
		//System.out.println("inOrderTraverseNonRecursive: "+inOrderTraverseNonRecursive(treeIn));
		
		
	}
	private static void test(Integer A){
		A++;
	}

	private static MyBinaryTree<Integer> makeTreePre(){
/*		int[] order={};
		MyBinaryTree<Integer> tree =new MyBinaryTree<Integer>();
		ArrayList<MyBinaryTree<Integer>> nodes=new ArrayList<MyBinaryTree<Integer>>(10);
		for(int i=0;i<10;i++){
			nodes.add(new MyBinaryTree<Integer>(i));
		}
		nodes.get(0).leftChild=nodes.get(1);
		nodes.get(0).rightChild=nodes.get(6);
		nodes.get(1).leftChild=nodes.get(2);
		nodes.get(1).rightChild=nodes.get(5);	
		nodes.get(6).leftChild=nodes.get(7);
		nodes.get(6).rightChild=nodes.get(9);
		nodes.get(2).leftChild=nodes.get(3);
		nodes.get(2).rightChild=nodes.get(4);
		nodes.get(7).leftChild=nodes.get(8);
		tree=nodes.get(0);
		return tree;*/
		return null;
	
	}
	
	private static MyBinaryTree<Integer> makeTreeIn(){
/*		MyBinaryTree<Integer> tree =new MyBinaryTree<Integer>();
		ArrayList<MyBinaryTree<Integer>> nodes=new ArrayList<MyBinaryTree<Integer>>(10);
		for(int i=0;i<10;i++){
			nodes.add(new MyBinaryTree<Integer>(i));
		}
		//int[] order={5,3,8,1,4,7,9,0,2,6};
		nodes.get(5).leftChild=nodes.get(3);
		nodes.get(5).rightChild=nodes.get(8);
		nodes.get(3).leftChild=nodes.get(1);
		nodes.get(3).rightChild=nodes.get(4);	
		nodes.get(8).leftChild=nodes.get(7);
		nodes.get(8).rightChild=nodes.get(9);
		nodes.get(1).leftChild=nodes.get(0);
		nodes.get(1).rightChild=nodes.get(2);
		nodes.get(7).leftChild=nodes.get(6);
		tree=nodes.get(5);
		return tree;*/
		return null;
	
	}
	private static MyBinaryTree<Integer> makeTreePost(){
		MyBinaryTree<Integer> tree =new MyBinaryTree<Integer>();
		ArrayList<MyBinaryTree<Integer>> nodes=new ArrayList<MyBinaryTree<Integer>>(10);
		for(int i=0;i<10;i++){
			nodes.add(new MyBinaryTree<Integer>(i));
		}
		int[] order={};
		nodes.get(9).leftChild=nodes.get(4);
		nodes.get(9).rightChild=nodes.get(8);
		nodes.get(4).leftChild=nodes.get(2);
		nodes.get(4).rightChild=nodes.get(3);	
		nodes.get(8).leftChild=nodes.get(6);
		nodes.get(8).rightChild=nodes.get(7);
		nodes.get(2).leftChild=nodes.get(0);
		nodes.get(2).rightChild=nodes.get(1);
		nodes.get(6).leftChild=nodes.get(5);
		tree=nodes.get(9);
		return tree;
	
	}
	
	
	public static MyBinaryTree<Integer> makeTree(){
		MyBinaryTree<Integer> tree =new MyBinaryTree<Integer>();
		ArrayList<MyBinaryTree<Integer>> nodes=new ArrayList<MyBinaryTree<Integer>>(10);
		for(int i=0;i<10;i++){
			nodes.add(new MyBinaryTree<Integer>(i));
		}
		//MyBinaryTree<Integer> tree0=nodes.get(0);
		nodes.get(0).leftChild=nodes.get(1);
		//System.out.println(nodes.get(0).leftChild.data);
		nodes.get(0).rightChild=nodes.get(2);
		nodes.get(1).leftChild=nodes.get(3);
		nodes.get(1).rightChild=nodes.get(4);	
		nodes.get(2).leftChild=nodes.get(5);
		nodes.get(2).rightChild=nodes.get(6);
		nodes.get(3).leftChild=nodes.get(7);
		nodes.get(3).rightChild=nodes.get(8);
		nodes.get(4).leftChild=nodes.get(9);
		tree=nodes.get(0);
		System.out.println(tree.data);
		System.out.println(tree.leftChild.data);
		System.out.println(tree.leftChild.leftChild.data);
		return tree;

	}
	public static MyBinaryTree<Integer> makeTree2(){
		MyBinaryTree<Integer> tree =new MyBinaryTree<Integer>(0);
		tree.leftChild=new MyBinaryTree<Integer>(1);
		tree.rightChild=new MyBinaryTree<Integer>(2);

		return tree;

	}
}
