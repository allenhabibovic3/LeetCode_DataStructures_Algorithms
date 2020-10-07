# where n is the number of steps, 
# return the total number of ways to get from step 0 -> step n using 1 or 2 as number of steps 

memo = {}


#since each problem is built on the previous number to climb n-1, n-2 steps, memoize the overlapping subproblems to avoid exponential time complexity using DP
#similar recursive definition as the nth term in the fibonacci sequence
def num_ways(n):
    if n <= 1:
        return 1
    if(n in memo):
        return memo[n]
    else:
        nw = num_ways(n-1) + num_ways(n-2) #num_ways(n-2) wont get invoked, since it is returned from the memo table, we get this operation at no cost(free)
        memo[n] = nw
        return nw


result = num_ways(3)
print(result)
