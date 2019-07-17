package algorithm.sort;

public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] array) {
        // 分配空间给辅助数组
        aux = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    /**
     * 将数组分成左半边和右半边两个数组（递归的一只到只剩一个元素）排序再归并回一个数组
     * @param array 排序的数组
     * @param lo 第一个元素下标
     * @param hi 最后一个元素下标
     */
    private static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) return;
        // 确认中间元素的下标
        int mid = lo + (hi - lo) / 2;
        // 递归的将左右分开排序（一直到只剩一个元素）
        sort(array, lo, mid);
        sort(array, (mid + 1), hi);
        merge(array, lo, mid, hi);
    }

    /**
     * 原地归并的抽象方法：
     * 先将 array 拷贝到辅助空间 aux 中，然后进行归并，归并的 4 个判断条件：
     * 1.左半边的元素用尽了（取右半边的元素）2.右半边的元素用尽了（取左半边的元素）
     * 3.右半边的当前元素小于左半边的当前元素（取右半边元素）4.右半边当前元素大于或者等于左半边当前元素（取左半边元素）
     * @param array 归并的数组
     * @param lo 第一个元素下标
     * @param mid 中间元素下标
     * @param hi 最后一个元素下标
     */
    private static void merge(Comparable[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 将数组拷贝到辅助空间
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        // 将辅助空间的元素归并回数组中
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (Common.less(aux[j], aux[i])) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }

}
