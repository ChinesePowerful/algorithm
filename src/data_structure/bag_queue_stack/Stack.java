package data_structure.bag_queue_stack;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node top;
    private int elementNumber = 0;

    public int size() {
        return elementNumber;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Item item) {
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        elementNumber++;
    }

    public Item pop() {
        Item item = top.item;
        top = top.next;
        elementNumber--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node current = top;

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
                pop();
            }
        }
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("哈哈哈");
        stringStack.push("嘤嘤嘤");
        stringStack.push("嘿嘿嘿");
        stringStack.push("呵呵呵");
        stringStack.push("嘎嘎嘎");
        stringStack.push("呱呱呱");

        for (String str : stringStack) {
            System.out.println(str);
        }

        stringStack.iterator().remove();
        System.out.println(stringStack.isEmpty());

    }

}
