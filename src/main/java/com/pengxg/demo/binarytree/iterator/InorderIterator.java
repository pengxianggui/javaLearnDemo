package com.pengxg.demo.binarytree.iterator;

import com.pengxg.demo.binarytree.TreeNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树的中旭遍历迭代器实现
 */
public class InorderIterator implements Iterator<Integer>
{
    private Stack<TreeNode> nodeStack;
    private TreeNode currentNode;
    public InorderIterator(TreeNode root)
    {
        nodeStack=new Stack<TreeNode>();
        currentNode=root;
    }
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return (currentNode!=null||!nodeStack.empty());
    }

    public Integer next() {
        // TODO Auto-generated method stub
        TreeNode nextNode=null;
        while(currentNode!=null)
        {
            nodeStack.push(currentNode);
            currentNode=currentNode.getLeftNode();
        }
        if(!nodeStack.isEmpty())
        {
            nextNode=nodeStack.pop();
            currentNode=nextNode.getRightNode();
        }
        return nextNode.getValue();
    }

    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

}