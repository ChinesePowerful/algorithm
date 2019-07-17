package algorithm.sort;

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
