class Solution:
    def calculate(self, s: str) -> int:
        i = 0
        numStack = []
        optStack = []
        while i < len(s):
            if  s[i].isdigit():
                num = 0
                while i < len(s) and s[i].isdigit():
                    num = 10 * num + int(s[i])
                    i += 1
                numStack.append(num)
            elif s[i] == '(':
                optStack.append(s[i])
                i += 1
            elif s[i] == ')':
                while optStack[-1] != '(':
                    self.__doCalculate(numStack, optStack)
                optStack.pop()
                i += 1
            else:
                while optStack and self.__getOrder(optStack[-1]) >= self.__getOrder(s[i]):
                    self.__doCalculate(numStack, optStack)
                optStack.append(s[i])
                i += 1
        while optStack != []:
            self.__doCalculate(numStack, optStack)
        return numStack[-1]
    
    def __doCalculate(self, numStack, optStack):
        num2 = numStack.pop()
        num1 = numStack.pop()
        opt = optStack.pop()
        ans = 0
        if opt == '+':
            ans = num1 + num2
        elif opt == '-':
            ans = num1 - num2
        elif opt == '*':
            ans = num1 * num2
        else:
            ans = int(num1 / num2)
        numStack.append(ans)

    def __getOrder(self, c) -> int:
        if c == '(' or c == ')':
            return 0
        elif c == '+' or c == '-':
            return 1
        else:
            return 2
