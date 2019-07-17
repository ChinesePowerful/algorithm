package algorithm.sort;

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
