package com.codecool.binarySearchTree;

public class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }


    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }


    public Node leftNode() {
        return left;
    }


    public Node rightNode() {
        return right;
    }


    public void setLeftNode(Node left) {
        this.left = left;
    }


    public void setRightNode(Node right) {
        this.right = right;
    }


    public String toString() {
        return Integer.toString(value);
    }
}
