package leetcode.ascending_linked_list_2_in_1;

import java.util.*;

/**
 * 升序链表
 */
public class AscendingLinkedList<Item extends Comparable<Item>> implements Iterable<Node<Item>> {

    /**
     * 迭代器实现
     */
    private class AscendingLinkedListIterator implements Iterator<Node<Item>> {

        private Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Node<Item> next() {
            Node<Item> node = current;
            current = current.getNext();
            return node;
        }
    }

    /**
     * 头节点、尾节点
     */
    private Node<Item> first;
    private Node<Item> last;

    /**
     * 节点的个数
     */
    private int numberOfNode = 0;

    /**
     * 链表是否为空
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 链表大小
     */
    public int size() {
        return numberOfNode;
    }

    /**
     * 返回迭代器
     */
    @Override
    public Iterator<Node<Item>> iterator() {
        return new AscendingLinkedListIterator();
    }

    /**
     * 添加节点
     */
    public void add(Item item) {
//        链表为空
        if (isEmpty()) {
            last = new Node<>(item);
            first = last;
            numberOfNode++;
            return;
        }
//        大于等于尾节点
        if (item.compareTo(last.getItem()) > 0) {
            last.setNext(new Node<>(item));
            last = last.getNext();
            numberOfNode++;
            return;
        }
//        小于头节点 or 头尾节点之间
        Node<Item> previousNode = null;
        for (Node<Item> currentNode : this) {
            if (currentNode.getItem().compareTo(item) > 0) {
                if (previousNode != null) {
                    previousNode.setNext(new Node<>(item, currentNode));
                } else {
                    first = new Node<>(item, currentNode);
                }
                numberOfNode++;
                return;
            } else {
                previousNode = currentNode;
            }
        }
    }

    public void addAll(Collection<Item> collection) {
        if (collection.isEmpty()) return;
        collection.forEach(this::add);
    }

    public void addAll(AscendingLinkedList<Item> ascendingLinkedList) {
        if (ascendingLinkedList.isEmpty()) return;
        ascendingLinkedList.forEach(node -> add(node.getItem()));
    }

    public static void main(String[] args) {
        AscendingLinkedList<Integer> ascendingLinkedList1 = new AscendingLinkedList<>();
        ascendingLinkedList1.add(3);
        ascendingLinkedList1.add(2);
        ascendingLinkedList1.add(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ascendingLinkedList1.addAll(list);
        AscendingLinkedList<Integer> ascendingLinkedList2 = new AscendingLinkedList<>();
        ascendingLinkedList1.add(6);
        ascendingLinkedList1.add(3);
        ascendingLinkedList1.add(9);
        ascendingLinkedList1.addAll(ascendingLinkedList2);
        for (Node<Integer> node : ascendingLinkedList1) {
            System.out.println(node.getItem());
        }
    }

}
