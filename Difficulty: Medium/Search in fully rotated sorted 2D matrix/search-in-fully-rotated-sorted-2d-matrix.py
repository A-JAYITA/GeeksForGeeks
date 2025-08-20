class Solution:
    def searchMatrix(self, mat, x):
        def search_rotated(row, target):
            lo, hi = 0, len(row) - 1
            while lo <= hi:
                mid = (lo + hi) // 2
                if row[mid] == target:
                    return True
                # Left half is sorted
                if row[lo] <= row[mid]:
                    if row[lo] <= target < row[mid]:
                        hi = mid - 1
                    else:
                        lo = mid + 1
                # Right half is sorted
                else:
                    if row[mid] < target <= row[hi]:
                        lo = mid + 1
                    else:
                        hi = mid - 1
            return False

        for row in mat:
            if search_rotated(row, x):
                return True
        return False