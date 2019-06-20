package com.pengxg.demo.linklist;

/**
 * 链表的相关算法
 */
public class Main {

    public static void main(String... args) {

    }


    /**
     * 传入一个单项链表，和指定的正整数K，返回这个链表倒数第K个节点。采用“先后双指针”的算法
     * @param node 单项链表
     * @param k 正整数，表示倒数第K个元素
     * @return
     */
    public SingleLinkNode CountDownK(SingleLinkNode node, int k) {
        if (k < 1 ) return null; // k必须为正整数
        SingleLinkNode firstPointer = node;
        SingleLinkNode secondPointer = node;

        // 先指针先移动k步
        for (int i = 0; i < k; i++) {
            firstPointer = firstPointer.getNextNode();
            if (firstPointer == null) {
                System.out.println("传入的链表长度不足K");
                return null;
            }
        }

        // 此时“先后”两个指针距离为k，再同步移动两个指针，当先指针nextNode为null,则表明后指针所处的位置就是我们想要找的倒数第K个节点
        while (firstPointer.getNextNode() != null) {
            firstPointer = firstPointer.getNextNode();
            secondPointer = secondPointer.getNextNode();
        }

        return secondPointer;
    }
}
