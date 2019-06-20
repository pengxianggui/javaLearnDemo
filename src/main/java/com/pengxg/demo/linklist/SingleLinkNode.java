package com.pengxg.demo.linklist;

/**
 * 【数据结构】单链表：通过持有下一个节点的引用，从而形成单向链表
 */
public class SingleLinkNode<T> {
    private SingleLinkNode nextNode;
    private T value;

    public SingleLinkNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(SingleLinkNode nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
