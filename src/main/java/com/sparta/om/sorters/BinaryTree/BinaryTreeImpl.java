package com.sparta.om.sorters.BinaryTree;

import com.sparta.om.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree{
    private final Node rootNode;
    private int nodeCount = 1;

    private int count = 0;

    private int[] sortedTree;

    public BinaryTreeImpl(int element) {
        rootNode = new Node(element);
    }
    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return nodeCount;
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addNodeToTree(rootNode, elements[i]);
        }
    }

    public boolean findElement(int element) {
        Node node = findNode(element);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node leftNode = findNode(element).getLeftChild();
        return leftNode.getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node rightNode = findNode(element).getRightChild();
        return rightNode.getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortedTree = new int[nodeCount];
        count = 0;
        sortTreeAsc(rootNode);
        return sortedTree;
    }

    @Override
    public int[] getSortedTreeDesc() {
        sortedTree = new int[nodeCount];
        count = 0;
        sortTreeDesc(rootNode);
        return sortedTree;
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                nodeCount++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
                nodeCount++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private void sortTreeAsc(Node node) {
        if (!node.isLeftChildEmpty()) {
            sortTreeAsc(node.getLeftChild());
        }
        sortedTree[count] = node.getValue();
        count++;
        if (!node.isRightChildEmpty()) {
            sortTreeAsc(node.getRightChild());
        }
    }

    private void sortTreeDesc(Node node) {
        if (!node.isRightChildEmpty()) {
            sortTreeAsc(node.getRightChild());
        }
        sortedTree[count] = node.getValue();
        count++;
        if (!node.isLeftChildEmpty()) {
            sortTreeAsc(node.getLeftChild());
        }
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else if (element > node.getValue()) {
                node = node.getRightChild();
            }
        }
        return null;
    }
}
