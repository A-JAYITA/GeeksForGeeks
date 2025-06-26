class Solution:
    def minValue(self, s, k):
        # Step 1: Count frequency of each character
        d = {}
        for i in s:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1

        # Step 2: Convert frequencies to a list
        l = list(d.values())

        # Step 3: Perform k reductions
        for j in range(k):
            x = l.index(max(l))  # Find index of max frequency
            l[x] = max(l) - 1     # Reduce that frequency by 1

        # Step 4: Compute the sum of squares
        a = 0
        for i in l:
            a += i ** 2

        return a

# Example usage
#sol = Solution()
#print(sol.minValue("abccc", 1))  # Output: 6