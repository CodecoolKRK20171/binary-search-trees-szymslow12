package com.codecool.binarySearchTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Integer[] elements) {
        root = buildNodes(elements);
    }

    public static BinarySearchTree buildTree(Integer[] intArray) {
        return new BinarySearchTree(intArray);
    }



    private Node buildNodes(Integer[] elements) {
        if (elements.length > 0) {
            int middle = ((int) Math.floor(elements.length / 2));
            Node newNode = new Node(elements[middle]);
            newNode.setLeftNode(buildNodes(
                copyArray(middle, elements, 0, middle)
            ));
            if (elements.length > 2) {
                newNode.setRightNode(buildNodes(
                    copyArray(middle, elements, middle, middle)
                ));
            }
            return newNode;
        }
        return null;
    }


    private Integer[] copyArray(int middleIndex, Integer[] elements, int srcPos, int length) {
        Integer[] integerArray = new Integer[middleIndex];
        System.arraycopy(elements, srcPos, integerArray, 0, length);
        return integerArray;
    }


    public void add(Integer value) {
        Node newNode = new Node(value);
        if (root.getValue() == value)
            throw new IllegalArgumentException("Elements already is in the tree!");
        if (value <= root.getValue()) {
            Node leftSiteOfRoot = root.leftNode();
            if (leftSiteOfRoot == null)
                root.setLeftNode(newNode);
            addNodeToProperParent(leftSiteOfRoot, newNode);
        } else {
            Node rightSiteOfRoot = root.rightNode();
            if (rightSiteOfRoot == null)
                root.setRightNode(newNode);
            addNodeToProperParent(rightSiteOfRoot, newNode);
        }
    }

    public void addNodeToProperParent(Node parent, Node newNode) {
        while (parent != null) {
            if (newNode.getValue() == parent.getValue()) {
                throw new IllegalArgumentException("Element already is in the tree!");
            } else if (newNode.getValue() <= parent.getValue()) {
                if (parent.leftNode() == null) {
                    parent.setLeftNode(newNode);
                    return;
                } else {
                    parent = parent.leftNode();
                }
            } else {
                if (parent.rightNode() == null) {
                    parent.setRightNode(newNode);
                    return;
                } else {
                    parent = parent.rightNode();
                }
            }
        }
    }

    public int minimalHeight() {
        return minimalHeight(root);
    }


    public int minimalHeight(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.leftNode() == null && root.rightNode() == null) {
            return 1;
        }

        if (root.leftNode() == null) {
            return minimalHeight(root.rightNode()) + 1;
        }

        if (root.rightNode() == null) {
            return minimalHeight(root.leftNode()) + 1;
        }
        return Math.min(minimalHeight(root.leftNode()),
                minimalHeight(root.rightNode())) + 1;
    }




    public static int minimalHeight(Integer[] intArray, int minimalHeight) {
        BinarySearchTree bsn = buildTree(intArray);
        return bsn.minimalHeight();
    }


    public static void main(String[] args) {
        Integer[] intArray = new Integer[50];
        for (int i = 0; i < 50; i++) {
            intArray[i] = i * 2 + 5;
        }
        BinarySearchTree bst = buildTree(intArray);
        System.out.println(minimalHeight(intArray, 13));
    }
}
