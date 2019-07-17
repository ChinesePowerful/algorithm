package algorithm.sort;

public class SelectSort {

    /**
     * 选择排序
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
