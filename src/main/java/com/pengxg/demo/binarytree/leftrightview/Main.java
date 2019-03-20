package com.pengxg.demo.binarytree.leftrightview;

import com.pengxg.demo.binarytree.TreeNode;

import java.util.List;

/**
 * 二叉树输出左、右视图结构
 */
public class Main {

    /**
     * 传入一个二叉树节点、层级（从0开始），列表。内部将遍历二叉树，找到这颗二叉树的左视图。并将结果存储在list中
     * 若n为树的节点数量，则时间复杂度为O(n)；
     * 若n为树的深度，则时间复杂度为O(2^n)
    * @param root
     * @param level
     * @param list
     */
    public void leftView(TreeNode root, int level, List list) {
        if (root == null) return;

        if (level == list.size()) {
            list.add(root.getValue());
        }

        // 先左后右，很重要
        leftView(root.getLeftNode(), level + 1, list);
        leftView(root.getRightNode(), level + 1, list);
    }


    public void rightView(TreeNode root, int level, List list) {
        if (root == null) return;

        if (level == list.size()) {
            list.add(root.getValue());
        }

        // 先右后左，很重要
        rightView(root.getRightNode(), level + 1, list);
        rightView(root.getLeftNode(), level + 1, list);
    }
}
