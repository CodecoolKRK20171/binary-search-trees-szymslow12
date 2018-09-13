package com.codecool.binarySearchTree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Integer[] elements) {
        root = buildNodes(elements);
    }

    public static BinarySearchTree buildTree(Integer[] intArray) {
        BinarySearchTree bst = new BinarySearchTree(intArray);
        return bst;
    }



    private Node buildNodes(Integer[] elements) {
        if (elements.length > 0) {
            int middle = ((int) Math.floor(elements.length / 2)) - 1;
            int middleIndex = middle - 1 < 0 ? 0: middle;
            Node newNode = new Node(elements[middleIndex]);
            newNode.setLeftNode(buildNodes(
                copyArray(middleIndex, elements, 0, middleIndex)
            ));
            if (elements.length > 2) {
                int itemAfterMiddle = middleIndex + 1;
                newNode.setRightNode(buildNodes(
                    copyArray(itemAfterMiddle, elements, itemAfterMiddle, itemAfterMiddle)
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
        if (root == null) {
            root = newNode;
            return;
        }

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
            System.out.print(newNode.getValue() + " - " + parent.getValue());
            if (newNode.getValue() <= parent.getValue()) {
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
        Integer[] intArray = {5, 1, 3, 5, 0, 1, 2, 3, 4 ,5 ,6 ,7 ,8};
        System.out.println(minimalHeight(intArray, 13));
    }
}
