package algorithm.sort;

public class QuickSort {

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 递归切分排序数组
     * @param array 切分的数组
     * @param lo 起始位置
     * @param hi 结束位置
     */
    private static void sort(Comparable[] array, int lo, int hi) {
        // 切分到只剩下一个元素的时候停止
        if (hi <= lo) return;
        // 将元素切分并且返回切分元素的下标
        int j = partition(array, lo, hi);
        // 递归的继续切分切分元素左边的元素
        sort(array, lo, (j -1));
        // 递归的继续切分切分元素右边的元素
        sort(array, (j + 1), hi);
    }

    /**
     * 设定一个将数组切分成左右两边的元素 v，左边的元素都小于 v，右边的元素都大于或者等于 v
     * @param array 切分的数组
     * @param lo 切分的起始位置
     * @param hi 切分的结束位置
     * @return j 返回切分元素最后在数组中的下标
     */
    private static int partition(Comparable[] array, int lo, int hi) {
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable v = array[lo];
        while (true) {
            // 从左到右扫描元素，如果找到大于或者等于 v 的元素，将它的下标记下
            while (Common.less(array[++i], v)) if (i == hi) break;
            // 从右到左扫描元素，如果找到小于 v 的元素，将它的下标记下
            while (Common.less(v, array[--j])) if (j == lo) break;
            // 如果 array[i] 已经在 array[j] 右边的，则无需交换位置
            // 等于号的原因：可能存在一个元素，即大于或者等于 v，也小于等于 v
            if (i >= j) break;
            // 将大于或者等于 v 的元素和小于 v 的元素交换位置
            Common.swap(i , j, array);
        }
        // 将切分元素放在切分好的元素的中间
        Common.swap(lo, j, array);
        return j;
    }

}
