package hust.xican;

import java.util.Scanner;

public class SubTreeJudge {
	class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right = null;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public  TreeNode buildTree(TreeNode root,int insert){
		//TreeNode root=root1;
		if(root==null){
			root=new TreeNode(insert);
			 
		}
		else{
			
			if(insert<root.val)root.left=buildTree(root.left, insert);
			else root.right = buildTree(root.right, insert);
			 
		
		}
		return root;
	}
/*	前序遍历测试
*					34
*			15		 		50
*		10     20  		40 		60
*	  8   14  17  30
*	  对应输出 34  15 10 14 20 17 30 50 40 60
*
**/
	public static void preOrder(TreeNode tree){
		
		if(tree==null)return  ;
		else{
			System.out.println(tree.val) ;
			preOrder(tree.left);
			preOrder(tree.right);
		}
		 
	}
	
public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		
		if(root1==null || root2==null)return false;
		boolean result=false;
		if(root1.val==root2.val){
			result=compareTree(root1.left,root2.left)||compareTree(root1.right,root2.right);
			}
		if(result==false)result=HasSubtree(root1.left, root2);
		if(result==false)result=HasSubtree(root1.right, root2);
		return result;
        
    }
public boolean compareTree(TreeNode tree1,TreeNode tree2){
	boolean result=false;
	if(tree1==null && tree2==null ) return true;
	if(tree1.val!=tree2.val)return false;
	else {
		result = compareTree(tree1.left, tree2.left) && compareTree(tree1.right, tree2.right);
		
	}
	return result;
}
	public static void main(String[] args) {
		SubTreeJudge subTreeJudge = new SubTreeJudge();
		TreeNode tree=subTreeJudge.new TreeNode(34);
		TreeNode tree1=subTreeJudge.new TreeNode(50);
		//TreeNode tree1=null;
		Scanner input = new Scanner(System.in);
		for(int i=0;i<10;i++){
			subTreeJudge.buildTree(tree,input.nextInt());
		}
		for(int i=0;i<2;i++){
			subTreeJudge.buildTree(tree1,input.nextInt());
		} 
		//preOrder(tree);
		System.out.println(subTreeJudge.HasSubtree(tree,tree1));
	}

}
