package data_structure.bag_queue_stack;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

//    定义头节点和尾节点
    private Node first;
    private Node last;
//    节点个数
    private int elementNumber = 0;

    public int size() {
        return elementNumber;
    }

    public boolean isEmpty() {
        return first == null;
    }

//    向队尾添加元素 O(n) = 1
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        elementNumber++;
    }

//    从队头开始删除元素 O(n) = 1
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        elementNumber--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            while (elementNumber > 0) {
                dequeue();
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("哈哈哈");
        stringQueue.enqueue("嘤嘤嘤");
        stringQueue.enqueue("嘿嘿嘿");
        stringQueue.enqueue("呵呵呵");
        stringQueue.enqueue("嘎嘎嘎");
        stringQueue.enqueue("呱呱呱");

        Iterator<String> stringIterator = stringQueue.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
//        上面等同于
        for (String str : stringQueue) {
            System.out.println(str);
        }

        stringIterator.remove();
        System.out.println(stringQueue.isEmpty());
    }

}
