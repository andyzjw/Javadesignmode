package com.structure.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 组合模式
 * @author andy
 *组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便 
 *使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 *
 *		BigTreeTree
 *		A		B
 *	  C
 */
public class CompositeTest {
	public static void main(String[] args) {
		Tree tree = new Tree("BigTreeTree");
		TreeNode node = new TreeNode("A");
		TreeNode node2 = new TreeNode("C");
		node.add(node2);
		tree.getRoot().add(node);
		tree.getRoot().add(new TreeNode("B"));
		System.out.println("build finish!");
 
		Enumeration<TreeNode> e = tree.getRoot().getChildren();
		while(e.hasMoreElements()) {
			TreeNode o = e.nextElement();
			System.out.println(o.getName());
		}
		
	}
}

class Tree{
	private TreeNode root  = null;
	public Tree(String name) {
		this.root  = new TreeNode(name);
	}
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
}
class TreeNode{
	private String name;
    private TreeNode parent;  
	private Vector<TreeNode> children = new Vector<TreeNode>();
	
	public TreeNode(String name) {
		this.name = name;
	}
	
	public void add(TreeNode node) {
		children.add(node);
	}
	public void remove(TreeNode node) {
		children.remove(node);
 
	}
	 
    //取得孩子节点  
    public Enumeration<TreeNode> getChildren(){  
        return children.elements();  
    }  

	
	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}