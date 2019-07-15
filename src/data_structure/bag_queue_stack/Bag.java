package data_structure.bag_queue_stack;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

//    节点类
    private class Node {
        Item item;
        Node next;
    }

//    定义头节点和节点个数
    private Node first;
    private int elementNumber = 0;

    public int size() {
        return elementNumber;
    }

    public boolean isEmpty() {
        return first == null;
    }

//    添加元素 O(n) = 1
    public void add(Item item) {
        Node oldFirst = this.first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        elementNumber++;
    }

//    返回一个迭代器
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

//    背包迭代器
    private class BagIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Bag<String> stringBag = new Bag<>();
        stringBag.add("哈哈哈");
        stringBag.add("嘤嘤嘤");
        stringBag.add("嘿嘿嘿");
        stringBag.add("呵呵呵");
        stringBag.add("嘎嘎嘎");
        stringBag.add("呱呱呱");

        Iterator<String> stringIterator = stringBag.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

}
