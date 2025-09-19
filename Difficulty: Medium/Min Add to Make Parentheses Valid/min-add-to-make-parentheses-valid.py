class Solution:
    def minParentheses(self, s):
        # code here
        st = []
        count = 0
        for char in s:
            if char == '(':  #add to stack 
                st.append(char)
            elif char == ')':
                if not st: #check if the stack is empty
                    count +=1
                elif st: #if stack not empty,then pop the top element as it has matching paranthesis
                    st.pop()
          
        return len(st)+count
        
        