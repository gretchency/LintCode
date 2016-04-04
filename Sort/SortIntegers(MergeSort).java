//Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // temp数组用来存merge的数组
        int[] temp = new int[A.length];
        mergeSort(temp, A, 0, A.length - 1);
    }
    
    public void mergeSort(int[] temp, int[] A, int left, int right) {
        //base case 非法的 或者只有1个数
        if (left >= right) {
            return;
        }
        
        //这种方法防止越界
        int middle = left + (right - left) / 2;
        mergeSort(temp, A, left, middle);
        mergeSort(temp, A, middle + 1, right);
        merge(temp, A, left, middle, right);
    }
    
    public void merge(int[] temp, int[] A, int left, int middle, int right) {
        //两个指针
        int i = left;
        int j = middle + 1;
        for (int k = 0; k < right - left + 1; k++) {
            //当j已经走完 i没做完 or A[j]和A[i]比较， A[i]较小
            if (i <= middle && (j > right || A[j] >= A[i])) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
        }
        
        for (int k = 0; k < right - left + 1; k++) {
            //把temp[]付给A[]
            A[left + k] = temp[k];
        }
    }

}