package com.codecool.javabst;

public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public void removeChild(TreeNode child) {
        if (left == child) {
            left = null;
        }
        else if (right == child) {
            right = null;
        }
        else {
            throw new IllegalArgumentException("Tried to remove non existing child");
        }
    }
}
