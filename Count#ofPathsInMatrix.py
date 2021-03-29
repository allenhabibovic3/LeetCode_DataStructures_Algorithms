#DYNAMIC PROGRAMMING PROBLEM
#GIVEN A MATRIX, COUNT THE # OF WAYS POSSIBLE
#TO GO FROM TOPLEFT MOST CELL TO
#BOTTOM RIGHTMOST CELL, ONLY MOVING RIGHT OR DOWN

#time complexity is O(ROWS*COLS)

def count_num_paths(m, n):
	C = [[0 for _ in range(m)] for _ in range(n)]

	#leftmost column is all one
	for i in range(m):
		C[i][0] = 1

	#topmost row is all one way
	for j in range(n):
		C[0][j] = 1

	for i in range(1, m):
		for j in range(1, n):
			C[i][j] = C[i-1][j] + C[i][j-1]

	return C[m-1][n-1]


if __name__ == "__main__":
	m = 3
	n = 3
	#square matrix, #rows = #cols

	result = count_num_paths(m, n)

	print(f"# OF WAYS = {result}")
