1.二分查找
=====

### 简介
- 二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法
- 但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列

### 实现
```java
public class BinarySearch {

    public static int rank(int key, int[] array) {

        int lo = 0;
        int hi = array.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key > array[mid]) lo = mid + 1;
            else if (key < array[mid]) hi = mid - 1;
            else return mid;
        }
        
        return -1;

    }

}
```