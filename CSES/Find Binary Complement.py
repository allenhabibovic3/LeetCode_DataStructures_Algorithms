num = 5

bit_str = bin(num)
bit_str = bit_str[2:]
print(bit_str)
complement = ""

for bit in bit_str:
	if bit == "1":
		complement += "0"
	else:
		complement += "1"

print(complement)
