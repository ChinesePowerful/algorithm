1.背包、队列和栈
=====

### 背包
背包是一种不支持从中删除元素的集合数据类型，它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素

用例也可以检查背包是否为空或者获取背包中元素的数量

```java
public class Bag<Item> implements Iterable<Item> {

//    节点类
    private class Node {
        Item item;
        Node next;
    }

//    背包的第一个节点和节点个数
    private Node first;
    private int elementNumber;

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

        public void remove() {

        }
    }

}
```

### 队列
队列是一种基于先进先出（FIFO）策略的集合类型

### 栈
栈是一种基于后进先出（LIFO）策略的集合类型