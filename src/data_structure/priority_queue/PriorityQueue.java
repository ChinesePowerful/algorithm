package data_structure.priority_queue;

public class PriorityQueue<Key extends Comparable<Key>> {

    /**
     * 基于堆的完全二叉树，元素存储在 priorityQueue[1 ~ elementNumber] 中
     * priorityQueue[0] 不使用
     */
    private Key[] priorityQueue;
    private int elementNumber;

}
