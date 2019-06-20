package com.pengxg.demo.binarytree.iterator;

import com.pengxg.demo.binarytree.TreeNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树的后续遍历递归实现
 */
public class PostorderIterator implements Iterator<Integer>
{
    Stack<TreeNode> nodeStack;
    TreeNode currentNode;
    TreeNode preNode;
    PostorderIterator(TreeNode root)
    {
        nodeStack=new Stack<TreeNode>();
        currentNode=root;
        preNode=null;
    }
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return (currentNode!=null)||(!nodeStack.empty()) ;
    }

    public Integer next() {
        // TODO Auto-generated method stub
        TreeNode nextNode=null;
        while(true)
        {
            if(currentNode!=null)
            {
                nodeStack.push(currentNode);
                currentNode=currentNode.getLeftNode();
            }else
            {
                currentNode=nodeStack.peek();
                if(currentNode.getRightNode() != null && preNode!=currentNode.getRightNode())
                {
                    currentNode=currentNode.getRightNode();
                }else
                    break;
            }
        }
        currentNode=preNode=nodeStack.pop();
        nextNode=currentNode;
        currentNode=null;
        return nextNode.getValue();
    }

    public void remove() {
        // TODO Auto-generated method stub

    }

}
