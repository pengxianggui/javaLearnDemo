package com.pengxg.demo.binarytree.mirror;

import com.pengxg.demo.binarytree.TreeNode;

/**
 * 给定一棵二叉树，对其进行镜像转换
 */
public class MirrorExchange {

    public static void main(String... args) {

    }

    /**
     * 传入一个节点，对其进行左右子节点对调。
     * 若n为树的深度，则时间复杂度：O(2^n)；
     * 若n为树的节点数，则时间复杂度为： O(n)
     * @param node
     */
    public static void mirror(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tempNode = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(tempNode);

        mirror(node.getLeftNode());
        mirror(node.getRightNode());
    }
}
