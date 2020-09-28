#list comprehensions

#create a list of n items in order

list1 = [n for n in range(10)]
print(list1)

list2 = [n for n in range(5, 20, 2)]
print(list2)

list3 = [n*n for n in range(20)]
print(list3)

import math
list4 = [math.sqrt(n) for n in range(10)]
print(list4)

list5 = [n for n in range(15) if n % 2 == 0]
print(list5)
