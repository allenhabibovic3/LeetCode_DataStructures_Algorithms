def hanoi(n, start, end):
	if n == 1:
		print(start, '->', end)
	else:
		aux = 6 - (start + end)
		hanoi(n-1, start, aux)
		print(start, '->', end)
		hanoi(n-1, aux, end)

hanoi(3, 1, 3)
