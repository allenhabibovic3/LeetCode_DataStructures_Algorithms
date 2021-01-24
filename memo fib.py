memo = {}

def fib(n):
    if n <= 1:
        return n
    if n in memo:
        return memo[n];
    else:
        num = fib(n-1) + fib(n-2)
        memo[n] = num
        return num

print(fib(50))
