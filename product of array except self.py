def prod_array_except_self(nums):
	n = len(nums)
	prod_array = [0] * n

	for i in range(n):
		curr_product = 1
		for j in range(n):
			if j == i:
				continue
			curr_product *= nums[j]
		prod_array[i] = curr_product
	return prod_array

ex1 = [1, 2, 3, 4]
result1 = prod_array_except_self(ex1)

print(result1)
