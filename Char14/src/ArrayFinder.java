public class ArrayFinder {

    public static void print(int[] array, int middle) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == middle) {
                System.out.print("*");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    /* 采用二分查找算法 */
    public static int indexOf(int[] array, int value) {
        int low = 0;
        int heigh = array.length - 1;
        int middle;

        while (low <= heigh) {
            //计算中间元素的索引
            middle = (low + heigh) / 2;
            print(array, middle);

            if (array[middle] == value) {
                return middle;
            }
            if (value < array[middle]) {
                heigh = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        //没有找到元素返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 9, 13, 17};
        System.out.println("location of 17：" + indexOf(array, 17));
    }
}
