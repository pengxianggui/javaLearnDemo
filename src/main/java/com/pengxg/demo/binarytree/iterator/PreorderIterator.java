package com.pengxg.demo.binarytree.iterator;


import com.pengxg.demo.binarytree.TreeNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树的前序遍历迭代器
 */
public class PreorderIterator implements Iterator<Integer> {
    Stack<TreeNode> nodeStack;
    TreeNode currentNode;
    PreorderIterator(TreeNode root) {
        nodeStack=new Stack<TreeNode>();
        currentNode = root;
    }

    public boolean hasNext() {
        // TODO Auto-generated method stub
        return (currentNode!=null)||(!nodeStack.empty());
    }

    public Integer next() {
        // TODO Auto-generated method stub
        TreeNode nextNode = null;
        if(currentNode!=null)
        {
            nodeStack.push(currentNode);
        }
        if(!nodeStack.empty())
        {
            nextNode=nodeStack.pop();
            if(nextNode.getRightNode() != null) {
                nodeStack.push(nextNode.getRightNode());
            }
            currentNode=nextNode.getLeftNode();
        }
        return nextNode.getValue();
    }

    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

}
