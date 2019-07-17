package algorithm.sort;

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
