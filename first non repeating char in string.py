from collections import Counter
x = "aaaabbbcccdddf"

s = list(x)
c = Counter(s)

for key, value in zip(c.keys(), c.values()):
	if value == 1:
		print(key)
		break
