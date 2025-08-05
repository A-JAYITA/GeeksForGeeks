class Solution:
    def isPalinSent(self, s):
        s=s.lower()
        s=''.join(char for char in s if char.isalnum())
        j=len(s)-1
        for i in range(len(s)//2):
            if s[i] != s[j]:
                return False
            j-=1
        return True