package algorithm.sort;

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
