package sort;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 快速排序的实现；
 *
 * 基本思想是：通过一趟排序将要排序的数据分割成两部分，其中一部分的所有数据都比另外一部分的所有数据都要小；
 * 然后再对这两部分数据分别进行上一行所描述的排序，整个排序过程递归进行，以此达到整个数据变成有序序列。
 */
public class QuickSort {

    /**
     * 用于递归排序操作
     * @param numbers 需要排序的数组
     * @param beginIndex 其起始坐标
     * @param endIndex 末尾坐标
     */
    public static void deal(int[]numbers, int beginIndex, int endIndex) {
        // 当该子序列只剩下一个数，返回
        if(beginIndex >= endIndex) {
            return;
        }
        // 将当前序列分为 左边皆小于右边 的形式，并获得中间的坐标
        int midIndex = sort(numbers,beginIndex,endIndex);
        // 对子序列进行递归排序 中间的值无需再排序 因为其左边皆小于它 右边皆大于它
        deal(numbers,beginIndex,midIndex-1);
        deal(numbers,midIndex+1,endIndex);
    }

    /**
     * 处理传入的数组部分，找到一个标准值，将其调换位置分为两部分；
     * 其中左边的数据全部小于标准值，右边的数据全部大于标准值，并返回标准值坐标
     * 而本算法实现中调换位置的具体操作就是：
     * 1）将数组的第一个数据作为标准值；
     * 2）先从右往左遍历，找到一个小于标准值的数据；
     * 3）再从左往右遍历，找到一个大于标准值的数据；
     * 4）交换两个数据的位置；
     * 5）重复2，3，4步的步骤，知道遍历的 始坐标 与 尾坐标 相等；此时在该坐标的两边已经符合要求
     * @param numbers 需要排序的数组
     * @param beginIndex 其起始坐标
     * @param endIndex 末尾坐标
     * @return 标准值坐标
     */
    public static int sort(int[]numbers, int beginIndex, int endIndex) {
        int current = numbers[beginIndex];
        int leftIndex = beginIndex;
        int rightIndex = endIndex;
        int temp = 0; // 存储从右往左遍历找到的第一个小于标准值的数据
        while(leftIndex < rightIndex) {
            while(leftIndex < rightIndex && numbers[rightIndex] >= current) {
                -- rightIndex;
            }
            temp = numbers[rightIndex];
            while(leftIndex < rightIndex && numbers[leftIndex] <= current) {
                ++ leftIndex;
            }
            numbers[rightIndex] = numbers[leftIndex];
            numbers[leftIndex] = temp;
        }
        // 最后将标准值换到中间的分割部分
        numbers[beginIndex] = temp;
        numbers[leftIndex] = current;
        print(numbers, leftIndex);
        return leftIndex;
    }

    public static void print(int[] array, int mid) {
        for(int i = 0; i < array.length; i ++) {
            if ( i == mid) {
                System.out.print("(" + array[i] + ")  ");
            } else {
                System.out.print(array[i] + "    ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] number = new int[10];
        for (int i = 0; i < number.length; i ++) {
            number[i] = (int)(Math.random() * 100);
        }
        print(number, -1);
        deal(number,0,number.length-1);
        print(number, -1);
    }
}
