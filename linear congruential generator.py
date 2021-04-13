def lcg(modulus, a, c, seed):
	while True:
		seed = (a * seed + c) % modulus
		yield seed

gen = lcg(193848, 298198397, 1989372910, 389284)

for _ in range(10):
	print(next(gen))
