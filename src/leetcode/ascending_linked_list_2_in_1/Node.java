package leetcode.ascending_linked_list_2_in_1;

/**
 * 链表中的一个节点
 */
public class Node<Item extends Comparable<Item>> implements Comparable<Item> {

    private Item item;
    private Node<Item> next;

    public Node() {}

    public Node(Node<Item> next) {
        this.next = next;
    }

    public Node(Item item) {
        this.item = item;
    }

    public Node(Item item, Node<Item> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public int compareTo(Item item) {
        return this.item.compareTo(item);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node<Item> getNext() {
        return next;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }
}
