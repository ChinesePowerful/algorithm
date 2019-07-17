排序算法
=====

### 通用方法
```java
public class Common {

    /**
     * 比较两个元素的大小
     * @return true or false
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个元素的位置
     * @param i 下标i
     * @param j 下标j
     * @param array 数组
     */
    public static void swap(int i, int j, Comparable[] array) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 数组是否从小到大
     * @param array 数组
     * @return true or false
     */
    public static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i - 1], array[i])) return false;
        }
        return true;
    }

    /**
     * 打印数组
     * @param array 数组
     */
    public static void show(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) System.out.print("[" + array[i] + ", ");
            else if (i == array.length - 1) System.out.print(array[i] + "]");
            else System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
```

### 1.冒泡排序（BubbleSort）
- 它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如小到大、首字母从A到Z）错误就把他们交换过来
- 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。

```java
public class BubbleSort {

    /**
     * 冒泡排序
     * 每一轮排序都将较大的元素向右排
     * @param array 排序数组
     */
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (Common.less(array[j + 1], array[j])) {
                    Common.swap((j + 1), j, array);
                }
            }
        }
    }

}
```

### 2.选择排序
- 一种最简单的排序算法：首先，找到数组中最小的那个元素，其次，将它和数组第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）再次，在剩下的元素中找到最小元素，将它和数组的第二个元素交换位置如此往复，直到将整个数组排序

```java
public class SelectSort {

    /**
     * O(n) = array.length * (array.length ~ 1)
     * @param array 排序数组
     */
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Common.less(array[j], array[min])) min = j;
            }
            Common.swap(i, min, array);
        }
    }

}
```

### 3.插入排序
- 首先，从第二个元素开始，和第一个元素进行比较，如果它小于第一个元素，将它和第一个元素交换位置
- 其次，第三个元素和第二个元素比较，如果它小于第二个元素，将它和第二个元素交换位置，再将它和第一个元素比较，如果小于第一个元素，将它们交换位置
- 如此往复，直到将整个数组排序

```java
public class InsertSort {

    /**
     * 插入排序
     * @param array 排序数组
     */
    public static void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && Common.less(array[j], array[j - 1]); j--) {
                Common.swap(j, j - 1, array);
            }
        }
    }

}
```

### 4.希尔排序
- 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，就形成了标准的插入排序

```java
public class ShellSort {

    /**
     * 希尔排序
     * @param array 排序数组
     */
    public static void sort(Comparable[] array) {
        // 排序的增量
        int h = 1;
        // 调整增量的大小
        while (h < array.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && Common.less(array[j], array[j - h]); j -= h) {
                    Common.swap(j, (j - h), array);
                }
            }
            h = h / 3;
        }
    }

}
```

### 5.归并排序
<iframe src="//player.bilibili.com/player.html?aid=18980253&cid=30955686&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
- 先将所有元素都拷贝到辅助空间 aux 中，然后在归并回原来的数组 array 中，归并的 4 个判断条件：
	1. 左半边的元素用尽了（取右半边的元素）
	2. 右半边的元素用尽了（取左半边的元素）
	3. 右半边的当前元素小于左半边的当前元素（取右半边元素）
    4. 右半边当前元素大于或者等于左半边当前元素（取左半边元素）

### 6.快速排序