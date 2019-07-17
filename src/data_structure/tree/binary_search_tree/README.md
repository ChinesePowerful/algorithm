3.二叉查找树（Binary Search Tree）
=====

### 简介
- 二叉排序树（Binary Sort Tree），又称二叉查找树（Binary Search Tree），亦称二叉搜索树
- 二叉查找树或者是一棵空树，或者是具有下列性质的二叉查找树：
    1. 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    2. 若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    3. 左、右子树也分别为二叉排序树；
    4. 没有键值相等的结点
    
### 实现
```java
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    /**
     * 节点类
     */
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

    /**
     * 以 node 为根结点的子树中查找并返回 key 所对应的值
     * 如果 node.key > key 则向左子结点递归地get(node.left, key)，直到 node.key == key or node == null
     * 如果 node.key < key 则向右子结点递归地get(node.right, key)，直到 node.key == key or node == null
     * 如果 node.key == key 则 return node.value;
     * @param node 以 node 为根结点的子树中查找并返回 key 所对应的值
     * @param key 查找的键
     * @return value or null
     */
    private Value get(Node node, Key key) {
        // 如果结点为空则返回 null
        if (node == null) return null;
        // compareTo(): 如果被调用的对象比参数小则返回 -1，大于则返回 1， 等于返回 0
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;
    }
    public Value get(Key key) {
        return get(this.root, key);
    }

    /**
     * 以 node 为根结点开始添加键为 key 的子结点
     * 如果 node == null 则创建一个新结点赋给 node
     * 如果 node.key == key 则 node.value = value
     * 如果 node.key > key 则向左子结点递归地 node.left = put(node.left, key, value)，直到 node == null or node.key == key
     * 如果 node.key < key 则向右子结点递归地 node.right = put(node.right, right, value)，直到 node == null or node.key == key
     * 最后记录下 node 的结点个数
     * @param node 以 node 为根结点开始添加键为 key 的子结点
     * @param key 添加的键
     * @param value 添加的值
     * @return node
     */
    private Node put(Node node, Key key, Value value) {
        // 如果根结点为空则直接返回一个新建结点
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.nodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);
    }

    /**
     * 递归的从左边的树打印到最右边的树
     * @param node 一般为 root
     */
    private void show(Node node) {
        if (node == null) return;
        show(node.left);
        System.out.println("[key: " + node.key + ", value: " + node.value + "]");
        show(node.right);
    }
    public void show() {
        show(this.root);
    }

    /**
     * 返回二叉查找树中最小的结点
     * @param node root
     * @return node
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }
    public Key min() { return min(this.root).key; }

    /**
     * 返回二叉查找树中最大的结点
     * @param node root
     * @return node
     */
    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }
    public Key max() { return max(this.root).key; }

    /**
     * 返回一个键小于或者等于 key 的最大结点
     * 如果结点不存在返回 null
     * 如果 node.key == key 返回 node
     * 如果 node.key > key 继续递归地向 node.left 查找，直到 node.key == key or (node.key > key && node.right == null)
     * 如果 node.key < key 则再向 node.right 查找，直到 node.key == key or (node.key > key && node.right == null)
     * @param node root
     * @param key 条件
     * @return null or node
     */
    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node temp = floor(node.right, key);
        if (temp != null) return temp;
        else return node;
    }
    public Key floor(Key key) {
        Node node =  floor(this.root, key);
        if (node == null) return null;
        return node.key;
    }

    /**
     * 返回一个键大于或者等于 key 的最小结点
     * 如果结点不存在返回 null
     * 如果 node.key == key 返回 node
     * 如果 node.key > key 继续递归地向 node.left 查找，直到 node.key == key or (node.key < key && node.left == null)
     * 如果 node.key < key 则再向 node.right 查找，直到 node.key == key or (node.key < key && node.left == null)
     * @param node root
     * @param key 条件
     * @return null or node
     */
    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp > 0) return ceiling(node.right, key);
        Node temp = ceiling(node.left, key);
        if (temp != null) return temp;
        else return node;
    }
    public Key ceiling(Key key) {
        Node node =  ceiling(this.root, key);
        if (node == null) return null;
        return node.key;
    }

    /**
     * 返回排名为 rank 的键（排名从 0 开始）
     * @param node root
     * @param rank 排名
     * @return key or null
     */
    private Node select(Node node, int rank) {
        if (node == null) return null;
        int t = size(node.left);
        if (t > rank) return select(node.left, rank);
        else if (t < rank) return select(node.right, rank - t - 1);
        else return node;
    }
    public Key select(int rank) { return select(this.root, rank).key; }

    /**
     * 返回键为 key 的排名（排名从 0 开始）
     * @param node root
     * @param key 条件
     * @return rank or null
     */
    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(node.left, key);
        else if (cmp > 0) return 1 + size(node.left) + rank(node.right, key);
        return size(node.left);
    }
    public int rank(Key key) {
        return rank(this.root, key);
    }


    /**
     * 删除二叉查找树的最小值
     * 从根结点开始向左子结点递归，直到 (node.left == null && node.left == null)
     * @param node root
     * @return root
     */
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.nodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void deleteMin() { this.root = deleteMin(this.root); }

    /**
     * 删除二叉查找树的最大值
     * 从根结点开始向右子结点递归，直到 (node.left == null && node.left == null)
     * @param node root
     * @return root
     */
    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.nodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void deleteMax() { this.root = deleteMax(this.root); }

    /**
     * 删除二叉查找树中键为 key 的结点
     * @param node root
     * @param key 条件
     * @return root
     */
    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        // 如果 key 小于当前结点继续向左递归查找
        if (cmp < 0) node.left =  delete(node.left, key);
            // 如果 key 大于当前结点继续向右递归查找
        else if (cmp > 0) node.right =  delete(node.right, key);
            // 当找到键等于 key 的结点时进行删除操作
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        // 重新统计 root 的子结点个数
        node.nodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void delete(Key key) { this.root = delete(this.root, key); }

    /**
     * 范围查找 [lo, hi] 内的 key
     * @param node root
     * @param queue 迭代队列
     * @param lo low
     * @param hi height
     */
    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) return;
        int cmp_lo = lo.compareTo(node.key);
        int cmp_hi = hi.compareTo(node.key);
        // 与当前结点进行比较，如果 key(lo) 小于 node.key 继续向左遍历
        if (cmp_lo < 0) keys(node.left, queue, lo, hi);
        // 与当前结点进行比较，如果 node.key 在 key(lo) 和 key(hi) 之间则将此结点的键添加到迭代队列 queue 中
        if (cmp_lo <= 0 && cmp_hi >= 0) queue.enqueue(node.key);
        // 与当前结点进行比较，如果 key(hi) 大于 node.key 继续向右遍历
        if (cmp_hi > 0) keys(node.right, queue, lo, hi);
    }
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keys = new Queue<>();
        keys(this.root, keys, lo, hi);
        return keys;
    }
    /**
     * 返回所有的 key
     * @return all keys
     */
    public Iterable<Key> keys() { return keys(min(), max()); }
    
}
```