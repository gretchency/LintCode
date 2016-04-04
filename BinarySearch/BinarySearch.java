public int binarySearch(int[] nums, int target) {
    if (nums == null && nums.length == 0) {
        return -1;
    }

    int start = 0;
    int end = nums.length - 1;

    //相邻或者相交就终止循环
    //缩小范围
    while (start + 1 < length) {
        mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            end = mid;
        } else if (nums[mid] < target) {
            start = mid;
        } else {
            end = mid;
        }
    }

    //进行比较
    if (nums[start] == target) {
        return start;
    }

    if (nums[end] == target) {
        return end;
    }

    return -1;
}