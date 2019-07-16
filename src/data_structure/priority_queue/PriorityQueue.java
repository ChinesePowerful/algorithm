package data_structure.priority_queue;

public class PriorityQueue<Key extends Comparable<Key>> {

    /**
     * 基于堆的完全二叉树，元素存储在 priorityQueue[1 ~ elementNumber] 中
     * priorityQueue[0] 不使用
     */
    private final Key[] priorityQueue;
    private int elementNumber;

    public PriorityQueue(int maxSize) {
        this.priorityQueue = (Key[]) new Comparable[maxSize];
    }

    public boolean isEmpty() {
        return elementNumber == 0;
    }

    public int size() {
        return elementNumber;
    }

    /**
     * 比较队列中元素的大小
     * @param i 下标i
     * @param j 下标j
     * @return true or false
     */
    private boolean less(int i, int j) {
        /**
         * i.compareTo(j)
         * if(i < j) return -1;
         * else if(i > j) return 1;
         * else return 0;
         */
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    /**
     * 交换两个元素在队列中的位置
     * @param i 下标i
     * @param j 下标j
     */
    private void exch(int i, int j) {
        Key temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    public void insert(Key key) {
        priorityQueue[++elementNumber] = key;
//        上浮使得堆有序化
        swim(elementNumber);
    }

    /**
     * 上浮使得堆有序化
     * @param k 一般为最后一个节点开始，递归的成为最大的节点
     */
    private void swim(int k) {
//        从最后一个节点开始，不断循环地比较父节点和子节点的元素大小
//        如果父节点小于子节点，则将它们交换位置，直到节点下标 <= 1
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 获取队列中的最大值
     * @return max
     */
    public Key getMax() {
        return priorityQueue[1];
    }

    public Key getAndDeleteMax() {
        Key max = priorityQueue[1];
//        将最大元素和最后一个元素交换，然后元素个数 -1
        exch(1, elementNumber--);
//        防止对象游离将它的引用设置为空
        priorityQueue[elementNumber + 1] = null;
//        下潜使得堆有序化
        sink(1);
        return max;
    }

    /**
     * 下潜使得堆有序化
     * @param k 一般从最大的节点开始，递归到两个子节点都比他小
     */
    private void sink(int k) {
//        循环地比较父节点的两个子节点的元素大小，将元素比较大的子节点标记起来
//        再比较父节点和这个大的子节点的元素大小，如果这个子节点的元素大小大于父节点的元素大小，则将它么交换位置
        while (2 * k < elementNumber) {
            int j = 2 * k;
            if (j < elementNumber && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void show() {
        for (int i = 1; i <= elementNumber; i++) {
            if (i == elementNumber) {
                System.out.print(priorityQueue[i]);
            }
            else {
                System.out.print(priorityQueue[i] + ", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        创建一个大小为 10 的优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10);
//        添加并展示
        priorityQueue.insert(5);
        priorityQueue.show();
        priorityQueue.insert(1);
        priorityQueue.show();
        priorityQueue.insert(6);
        priorityQueue.show();
        priorityQueue.insert(8);
        priorityQueue.show();
        priorityQueue.insert(9);
        priorityQueue.show();

        priorityQueue.getAndDeleteMax();
        priorityQueue.show();

    }

}
