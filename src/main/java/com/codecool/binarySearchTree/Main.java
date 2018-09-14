package com.codecool.binarySearchTree;

public class Main {

    public static void main(String[] args) {
        Integer[] numberArray = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTree binarySearchTree = BinarySearchTree.buildTree(numberArray);

        System.out.println("Minimal height -> Expected: 3, Actual: " + binarySearchTree.minimalHeight());
        System.out.println("Case: find 5, Expected: true, Actual: " + binarySearchTree.searchElement(5));
        System.out.println("Case: find 0, Expected: true, Actual: " + binarySearchTree.searchElement(0));
        System.out.println("Case: find 9, Expected: true, Actual: " + binarySearchTree.searchElement(9));
        System.out.println("Case: find -1, Expected: false, Actual: " + binarySearchTree.searchElement(-1));
        System.out.println("Case: find 10, Expected: false, Actual: " + binarySearchTree.searchElement(10));

        binarySearchTree.add(234);
        binarySearchTree.remove(1);
        binarySearchTree.remove(3);

        System.out.println("Minimal height -> Expected: 2, Actual: " + binarySearchTree.minimalHeight());
    }
}
