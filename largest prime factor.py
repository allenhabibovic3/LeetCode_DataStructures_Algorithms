def largestPrimeFactor(n):
    
    list_of_factors = []
    
    for i in range(1, n):
        if n % i == 0:
            list_of_factors.append(i)

    list_of_primes = []

    for num in list_of_factors:
        if isPrime(num):
            list_of_primes.append(num)

    return max(list_of_primes)


def isPrime(n):

    is_Prime = True

    for i in range(2, n):
        if n % i == 0:
            is_Prime = False

    return is_Prime

result = largestPrimeFactor(70)
print(result)
