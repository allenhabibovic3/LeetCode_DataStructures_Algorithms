def evenFibSum(n):
    fib = [0]*n
    fib[0] = 1
    fib[1] = 1

    evenSum = 0

    for i in range(2, n):
        fib[i] = fib[i-1] + fib[i-2]
        if fib[i] % 2 == 0:
            evenSum += fib[i]

    return evenSum


print(evenFibSum(10))
