def decimalToBinary(n):
	binary_str = ""
	while(n != 0):
		binary_str += str(n % 2)
		n //= 2
	reversed_bin_str = ""

	for i in range(len(binary_str)-1,-1, -1):
		reversed_bin_str += binary_str[i]

	return reversed_bin_str

print(decimalToBinary(16))
