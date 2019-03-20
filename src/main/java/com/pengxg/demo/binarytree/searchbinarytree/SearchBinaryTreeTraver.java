package com.pengxg.demo.binarytree.searchbinarytree;

import com.pengxg.demo.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SearchBinaryTreeTraver {

    /**
     * 传入一棵二叉搜索树，和正整数k，返回二叉搜索树第K大的节点。
     * 二叉搜索树的特性是：任意节点都大于左子树所有节点的值，小于右子树所有节点的值。因此二叉搜索树的中序遍历就是从小到大的排序。问题转变为
     * 二叉搜索树的中序遍历，返回第K个节点
     * @param rootNode
     * @param k
     * @return
     */
    public TreeNode findK(TreeNode rootNode, int k) {
        if (k < 1) return null; // k的有效性判断

        List<TreeNode> list = new ArrayList<TreeNode>();

        inOrder(rootNode, list); // 二叉树的中序遍历

        if (k > list.size()) { // k的范围判断
            return null;
        }

        return list.get(k - 1);
    }

    /**
     * 二叉树的中序遍历，将遍历结果放入传入的空list中
     * @param rootNode
     * @param list
     */
    private void inOrder(TreeNode rootNode, List<TreeNode> list) {
        if (rootNode == null) return;

        inOrder(rootNode.getLeftNode(), list);
        list.add(rootNode);
        inOrder(rootNode.getRightNode(), list);
    }
}
