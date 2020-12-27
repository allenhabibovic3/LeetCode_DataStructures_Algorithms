##each letter in J is a stone that is a jewel
##each letter in S is a stone

#count how many jewels there are in set s
#a != A

j = "aA"
s = "aAbbbb"

count = 0
for letter in s:
	if letter in list(j):
		count += 1

print(count)
