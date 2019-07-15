1.背包、队列和栈
=====

### 背包
- 背包是一种不支持从中删除元素的集合数据类型，它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素
- 用例也可以检查背包是否为空或者获取背包中元素的数量

```java
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
```

### 队列
- 队列是一种基于先进先出（FIFO）策略的集合类型
```java
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
```

### 栈
- 栈是一种基于后进先出（LIFO）策略的集合类型
```java
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
```