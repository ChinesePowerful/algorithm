package data_structure.tree.binary_search_tree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int nodeNumber;
        public Node(Key key, Value value, int nodeNumber) {
            this.key = key;
            this.value = value;
            this.nodeNumber = nodeNumber;
        }
    }

    //    根节点
    private Node root;

    /**
     * 返回二叉树节点个数
     * @return number
     */
    public int size() {
        return size(root);
    }

    /**
     * 以此节点为二叉树的节点个数
     * @param node 一颗二叉树根节点
     * @return
     */
    private int size(Node node) {
        if (node == null) return 0;
        else return node.nodeNumber;
    }

}