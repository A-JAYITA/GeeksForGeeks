class Solution {
    public int searchInsertK(int[] arr, int k) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] < k) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}